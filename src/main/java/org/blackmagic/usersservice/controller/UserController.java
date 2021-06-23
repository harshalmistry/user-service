package org.blackmagic.usersservice.controller;

import org.blackmagic.usersservice.modal.RegistrationUser;
import org.blackmagic.usersservice.modal.User;
import org.blackmagic.usersservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author niharsh
 * @created 16/06/2021 - 20:16
 */
@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@Valid @RequestBody RegistrationUser user){
        logger.debug("registering user - {} - {}", user.getEmail(), user.getDob());
        return userService.saveUser(user);
    }

    @PostMapping("/authenticate")
    public long authenticateUser(@Valid @RequestBody User user){
        logger.debug("authenticating user - {}", user.getEmail());
        return userService.authenticate(user);
    }
}