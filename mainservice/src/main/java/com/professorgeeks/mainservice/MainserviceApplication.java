package com.professorgeeks.mainservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MainserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainserviceApplication.class, args);
    }

}
