package com.example.spring.sample3;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.spring.sample3.config.AuthoscanConfig;
import com.example.spring.sample3.services.UserServiceTest;
import com.example.spring.sample3.services.impl.BaseUserServicesTest;

public class Application {

    private static ApplicationContext configWithoutBean() {
        return new AnnotationConfigApplicationContext(AuthoscanConfig.class);
    }

    public static void main(String[] args) {
        System.out.println("Sample 3");
        ApplicationContext context = configWithoutBean();
        //UserServiceTest userService = context.getBean(UserServiceTest.class);
        UserServiceTest userService = context.getBean("InMemoryUserServiceTest", UserServiceTest.class);
        userService.testUserService();

        try {
         // Здесь произойдет исключение, так как BaseUserServicesTest запроксирован
            BaseUserServicesTest userService2 = context.getBean(BaseUserServicesTest.class);
            userService2.testUserService();
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("Bean BaseUserServicesTest not found");
        }
        UserServiceTest userService2 = context.getBean("baseUserServicesTest", UserServiceTest.class);
        userService2.testUserService();

    }

}
