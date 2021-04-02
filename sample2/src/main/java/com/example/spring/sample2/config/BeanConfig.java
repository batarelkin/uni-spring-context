package com.example.spring.sample2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.spring.sample2.services.UserService;
import com.example.spring.sample2.services.UserServiceTest;
import com.example.spring.sample2.services.impl.BaseUserServicesTest;
import com.example.spring.sample2.services.impl.InMemoryUserService;

/**
 * Конфигурация с явным заданием компонентов
 */
@Configuration
public class BeanConfig {

    @Bean
    public UserServiceTest testService() {
        System.out.println("Creating UserServiceTest");
        return new BaseUserServicesTest(service());
    }
    
    @Bean
    public UserService service() {
        System.out.println("Creating UserService");
        return new InMemoryUserService();
    }
    
}
