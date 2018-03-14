package com.example.spring.sample2.services.impl;

import com.example.spring.sample2.model.User;
import com.example.spring.sample2.services.UserService;
import com.example.spring.sample2.services.UserServiceTest;

public class BaseUserServicesTest implements UserServiceTest {

    private UserService service;

    public BaseUserServicesTest(UserService service) {
        this.service = service;
    }

    @Override
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
