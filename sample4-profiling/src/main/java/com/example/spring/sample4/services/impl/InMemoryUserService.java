package com.example.spring.sample4.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Named;

import org.springframework.context.annotation.Primary;

import com.example.spring.sample4.Profiling;
import com.example.spring.sample4.model.User;
import com.example.spring.sample4.services.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!simple")
public class InMemoryUserService implements UserService {

    private final Map<Long, User> users = new HashMap<>();

    private final AtomicInteger ID = new AtomicInteger();

    @Override
    @Profiling
    public User getUser(long id) {
        return users.get(id);
    }

    @Override
    public boolean deleteUser(long id) {
        return users.remove(id) != null;
    }

    @Override
    @Profiling
    public User createUser(User user) {
        User newUser = new User();
        newUser.setId(ID.incrementAndGet());
        newUser.setLogin(user.getLogin());
        newUser.setName(user.getName());
        return newUser;
    }

}
