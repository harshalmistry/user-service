package org.blackmagic.usersservice.service;

import org.blackmagic.usersservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niharsh
 * @created 16/06/2021 - 20:20
 */
public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    List<User> getUsers();
    User getUserByEmail(String email);
}
