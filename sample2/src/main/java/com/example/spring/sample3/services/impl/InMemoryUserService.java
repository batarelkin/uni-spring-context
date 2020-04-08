package com.example.spring.sample3.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Named;

import com.example.spring.sample3.model.User;
import com.example.spring.sample3.services.UserService;

@Named("inMemoryUserService")
//@Component
//@Qualifier("inMemoryUserService")
public class InMemoryUserService implements UserService {

    private final Map<Long, User> users = new HashMap<>();

    private final AtomicInteger ID = new AtomicInteger();

    @Override
    public User getUser(long id) {
        return users.get(id);
    }

    @Override
    public boolean deleteUser(long id) {
        return users.remove(id) != null;
    }

    @Override
    public User createUser(User user) {
        User newUser = new User();
        newUser.setId(ID.incrementAndGet());
        newUser.setLogin(user.getLogin());
        newUser.setName(user.getName());
        return newUser;
    }

}
