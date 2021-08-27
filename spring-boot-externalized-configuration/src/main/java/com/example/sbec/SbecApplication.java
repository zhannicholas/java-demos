package com.example.sbec;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SbecApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbecApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(Environment environment) {
        return args -> {
            System.out.printf("name=%s%n", environment.getProperty("name"));
        };
    }

}
