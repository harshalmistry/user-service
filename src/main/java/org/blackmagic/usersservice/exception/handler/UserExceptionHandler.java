package org.blackmagic.usersservice.exception.handler;

import org.blackmagic.usersservice.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author niharsh
 * @created 21/06/2021 - 12:56
 */
@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(UserExceptionHandler.class);

    @ExceptionHandler({UserNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest req){
        logger.error(ex.getMessage());
        return handleExceptionInternal(ex, "Account does not exist, Sign-up Today!", new HttpHeaders(), HttpStatus.NOT_FOUND, req);
    }

    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    protected ResponseEntity<Object> handleDuplicateInsertion(Exception ex, WebRequest req){
        ex.printStackTrace();
        return handleExceptionInternal(ex, "Account already exists.", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, req);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        logger.error("Invalid request received - {}", errors);
        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);

    }


}
