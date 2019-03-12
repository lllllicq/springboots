package com.suock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableJpaRepositories
@SpringBootApplication
public class start extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(start.class, args);
    }
}
