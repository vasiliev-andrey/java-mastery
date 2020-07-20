package com.mastery.java.task.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mastery")
public class AppConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(AppConfiguration.class, args);
    }
}
