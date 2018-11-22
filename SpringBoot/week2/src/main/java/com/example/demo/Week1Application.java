package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Week1Application {

	public static void main(String[] args) {
		SpringApplication.run(Week1Application.class, args);
	}
}
