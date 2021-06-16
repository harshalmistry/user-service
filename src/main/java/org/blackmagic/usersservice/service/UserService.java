package org.blackmagic.usersservice.service;

import org.blackmagic.usersservice.entity.User;

/**
 * @author niharsh
 * @created 16/06/2021 - 20:20
 */
public interface UserService {
    User saveUser(User user);
    User getUserByEmail(String email);
}
