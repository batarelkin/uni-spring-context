package com.example.spring.sample2.services.impl;

import com.example.spring.sample2.model.User;
import com.example.spring.sample2.services.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.SecureRandom;
import java.util.Random;

@Component
@Profile("simple")
public class SimpleUserService implements UserService {

    private Random random = new SecureRandom();

    @PostConstruct
    private void init() {
        System.out.println("SimpleUserService initialized");
    }

    @Override
    public User getUser(long id) {
        User user = new User();
        user.setId(id);
        user.setLogin("vpetrov");
        user.setName("Василий Петров");
        return user;
    }

    @Override
    public boolean deleteUser(long id) {
        return true;
    }

    @Override
    public User createUser(User user) {
        User newUser = new User();
        newUser.setId(random.nextLong());
        newUser.setLogin(user.getLogin());
        newUser.setName(user.getName());
        return newUser;
    }

}
