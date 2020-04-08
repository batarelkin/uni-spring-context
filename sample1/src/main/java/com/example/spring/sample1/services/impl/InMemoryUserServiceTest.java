package com.example.spring.sample1.services.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.example.spring.sample1.model.User;
import com.example.spring.sample1.services.UserService;
import com.example.spring.sample1.services.UserServiceTest;

@Named
//@Component
public class InMemoryUserServiceTest implements UserServiceTest {
    
    @Inject
    private UserService userService;
    
    @Override
    public void testUserService() {
        System.out.println("InMemoryUserServiceTest");
        System.out.println("Тестируем создание пользователя");
        User user = userService.createUser(new User(0, "login1", "Виктор Потапов"));
        System.out.println(String.format("Создан пользователь: %s", user.toString()));
        System.out.println("Тестируем получение пользователя");
        User user1 = userService.getUser(user.getId());
        System.out.println(String.format("Пользователь %d: %s", user.getId(), user.toString()));
        assert user.equals(user1);
    }

}
