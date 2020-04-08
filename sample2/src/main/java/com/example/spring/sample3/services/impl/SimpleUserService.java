package com.example.spring.sample3.services.impl;

import java.security.SecureRandom;
import java.util.Random;

import javax.inject.Named;

import com.example.spring.sample3.model.User;
import com.example.spring.sample3.services.UserService;

@Named
//@Component
public class SimpleUserService implements UserService {

    private Random random = new SecureRandom();

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
