package com.misolab.greatdays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class GreatDaysApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatDaysApplication.class, args);
	}

}
