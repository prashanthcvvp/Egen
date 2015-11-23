package com.coding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class CodingTastApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodingTastApplication.class, args);
        System.out.println("Server Started on port 8080");
    }
}
