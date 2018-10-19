package com.experisproject.experisproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExperisProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExperisProjectApplication.class, args);
    }
}
