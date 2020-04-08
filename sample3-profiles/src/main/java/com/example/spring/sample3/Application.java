package com.example.spring.sample3;

import com.example.spring.sample3.config.AutoscanConfig;
import com.example.spring.sample3.services.UserServiceTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    private static ApplicationContext configWithBean() {
        return new AnnotationConfigApplicationContext(AutoscanConfig.class);
    }

    public static void main(String[] args) {
        System.out.println("Sample 2");
        ApplicationContext context = configWithBean();
        UserServiceTest userService = context.getBean(UserServiceTest.class);
        userService.testUserService();

    }

}
