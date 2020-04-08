package com.example.spring.sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.spring.sample3.services.UserServiceTest;
import com.example.spring.sample3.config.BeanConfig;

public class Application {

    private static ApplicationContext configWithBean() {
        return new AnnotationConfigApplicationContext(BeanConfig.class);
    }

    public static void main(String[] args) {
        System.out.println("Sample 2");
        ApplicationContext context = configWithBean();
        UserServiceTest userService = context.getBean(UserServiceTest.class);
        userService.testUserService();

    }

}
