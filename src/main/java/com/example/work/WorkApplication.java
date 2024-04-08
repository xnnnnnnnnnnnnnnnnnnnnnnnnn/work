package com.example.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication

public class WorkApplication {



    public static void main(String[] args) {
        SpringApplication.run(WorkApplication.class, args);
    }



}
