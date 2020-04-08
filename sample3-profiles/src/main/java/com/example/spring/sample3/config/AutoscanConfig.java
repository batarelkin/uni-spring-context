package com.example.spring.sample3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация с автоматическим сканированием компонентов
 */
@Configuration
@ComponentScan(basePackages = "com.example.spring.sample3")
public class AutoscanConfig {

}
