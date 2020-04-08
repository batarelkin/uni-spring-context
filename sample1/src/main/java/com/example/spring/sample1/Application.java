package com.example.spring.sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.spring.sample1.config.AutoscanConfig;
import com.example.spring.sample1.services.UserServiceTest;

public class Application {

    private static ApplicationContext configWithoutBean() {
        return new AnnotationConfigApplicationContext(AutoscanConfig.class);
    }

    public static void main(String[] args) {
        System.out.println("Sample 1");
        ApplicationContext context = configWithoutBean();
        UserServiceTest userService = context.getBean(UserServiceTest.class);
        userService.testUserService();
    }

}
