package com.mastery.java.task.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.mastery")
@EntityScan("com.mastery.java.task.dto")
@EnableTransactionManagement
public class AppConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(AppConfiguration.class, args);
    }
}
