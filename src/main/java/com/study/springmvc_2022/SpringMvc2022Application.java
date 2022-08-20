package com.study.springmvc_2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringMvc2022Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvc2022Application.class, args);
    }

}
