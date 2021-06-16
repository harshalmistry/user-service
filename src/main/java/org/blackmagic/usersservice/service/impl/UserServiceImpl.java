package org.blackmagic.usersservice.service.impl;

import org.blackmagic.usersservice.entity.User;
import org.blackmagic.usersservice.repository.UserRepository;
import org.blackmagic.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niharsh
 * @created 16/06/2021 - 20:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
