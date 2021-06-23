package org.blackmagic.usersservice.exception;

/**
 * @author niharsh
 * @created 21/06/2021 - 12:55
 */
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String userEmail) {
        super("No User found for  - " + userEmail);
    }
}
