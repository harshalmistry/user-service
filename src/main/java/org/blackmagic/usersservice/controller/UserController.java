package org.blackmagic.usersservice.controller;

import org.blackmagic.usersservice.entity.User;
import org.blackmagic.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author niharsh
 * @created 16/06/2021 - 20:16
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping("/authenticate")
    public boolean authenticateUser(@RequestBody User user){
        User userByEmail = userService.getUserByEmail(user.getEmail());
        System.out.println(userByEmail);
        if(userByEmail != null) return true;
        return false;
    }
}