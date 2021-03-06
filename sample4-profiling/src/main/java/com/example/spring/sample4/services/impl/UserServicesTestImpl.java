package com.example.spring.sample4.services.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.example.spring.sample4.Profiling;
import com.example.spring.sample4.model.User;
import com.example.spring.sample4.services.UserService;
import com.example.spring.sample4.services.UserServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServicesTestImpl implements UserServiceTest {
    
    private final UserService service;
    
    @Autowired
    public UserServicesTestImpl(UserService service) {
        this.service = service;
    }

    @Override
    @Profiling
    public void testUserService() {
        test(service);
    }
    
    private void test(UserService userService) {
        System.out.println("AllUserServicesTest");
        System.out.println("Тестируем создание пользователя");
        User user = userService.createUser(new User(0, "login1", "Виктор Потапов"));
        System.out.println(String.format("Создан пользователь: %s", user.toString()));
        System.out.println("Тестируем получение пользователя");
        User user1 = userService.getUser(user.getId());
        System.out.println(String.format("Пользователь %d: %s", user.getId(), user.toString()));
        assert user.equals(user1);
    }

}
