package org.blackmagic.usersservice.service;

import org.blackmagic.usersservice.entity.UserEntity;
import org.blackmagic.usersservice.modal.User;

/**
 * @author niharsh
 * @created 16/06/2021 - 20:20
 */
public interface UserService {
    User saveUser(User user);
    long authenticate(User User);
}
