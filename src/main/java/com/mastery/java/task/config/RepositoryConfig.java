package com.mastery.java.task.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.mastery.java.task.dao")
public class RepositoryConfig {
}
