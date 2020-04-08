package com.example.spring.sample4;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.spring.sample4.config.AuthoscanConfig;
import com.example.spring.sample4.services.UserServiceTest;
import com.example.spring.sample4.services.impl.UserServicesTestImpl;

public class Application {

    private static ApplicationContext configWithoutBean() {
        return new AnnotationConfigApplicationContext(AuthoscanConfig.class);
    }

    public static void main(String[] args) {
        System.out.println("Sample 4");
        ApplicationContext context = configWithoutBean();
        //UserServiceTest userService = context.getBean(UserServiceTest.class);
        UserServiceTest userService = context.getBean(UserServiceTest.class);
        userService.testUserService();

        try {
            // Здесь произойдет исключение, так как BaseUserServicesTest запроксирован
            UserServicesTestImpl userService2 = context.getBean(UserServicesTestImpl.class);
            userService2.testUserService();
        } catch (NoSuchBeanDefinitionException e) {
            System.err.println("Bean BaseUserServicesTest not found");
        }

    }

}
