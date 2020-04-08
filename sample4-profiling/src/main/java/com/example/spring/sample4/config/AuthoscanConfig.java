package com.example.spring.sample4.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация с автоматическим сканированием компонентов
 */
@Configuration
@ComponentScan(basePackages = "com.example.spring.sample4")
public class AuthoscanConfig {

}
