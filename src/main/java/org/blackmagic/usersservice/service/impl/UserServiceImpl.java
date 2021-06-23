package org.blackmagic.usersservice.service.impl;

import org.blackmagic.usersservice.entity.UserEntity;
import org.blackmagic.usersservice.exception.UserNotFoundException;
import org.blackmagic.usersservice.mapper.UserMapper;
import org.blackmagic.usersservice.modal.RegistrationUser;
import org.blackmagic.usersservice.modal.User;
import org.blackmagic.usersservice.repository.UserRepository;
import org.blackmagic.usersservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * @author niharsh
 * @created 16/06/2021 - 20:23
 */
@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        Objects.requireNonNull(user);
        UserEntity userEntity = userMapper.userToUserEntity(user);
        logger.debug("user mapped {} -> {}", user, userEntity);
        UserEntity save = userRepository.save(userEntity);
        logger.info("User registration successful - {} - {}", save.getId(), save.getEmail());
        return userMapper.UserEntityToUser(save);
    }

    @Override
    public long authenticate(User user) {
        Objects.requireNonNull(user);
        String userEmail = user.getEmail();
        Optional<UserEntity> optionalUser = userRepository.findByEmail(userEmail);
        optionalUser.orElseThrow(() -> new UserNotFoundException(userEmail));
        boolean isUser = optionalUser
                .filter(dbUser -> {
                    return dbUser.getPassword().equalsIgnoreCase(user.getPassword());
                })
                .isPresent();
        long userId = -1;
        if(isUser){
            userId = optionalUser.get().getId();
        }
        logger.info("authenticating user {} status {} ", user.getEmail(), userId);
        return userId;
    }
}
