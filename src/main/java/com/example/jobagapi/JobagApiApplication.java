package com.example.jobagapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JobagApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobagApiApplication.class, args);
    }

}
