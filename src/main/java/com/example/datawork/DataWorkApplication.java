package com.example.datawork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DataWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataWorkApplication.class, args);
    }

}
