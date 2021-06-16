package org.blackmagic.usersservice.configuration;

import org.blackmagic.usersservice.entity.User;
import org.blackmagic.usersservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author niharsh
 * @created 16/06/2021 - 20:49
 */
@Component
public class LoadDataRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        userRepository.save(new User(1, "er.harshalmistry@gmail.com", "password", new Date()));
        userRepository.save(new User(2, "niharsh2211@gmail.com", "password", new Date()));
        userRepository.save(new User(3, "niti.panchal@gmail.com", "password", new Date()));
        userRepository.findAll().forEach(System.out::println);

    }
}
