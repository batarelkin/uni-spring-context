package com.example.spring.sample2.services.impl;

import com.example.spring.sample2.model.User;
import com.example.spring.sample2.services.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Profile("in-memory")
public class InMemoryUserService implements UserService {

    private final Map<Long, User> users = new HashMap<>();

    private final AtomicInteger ID = new AtomicInteger();

    @PostConstruct
    private void init() {
        System.out.println("InMemoryUserService initialized");
    }

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
