package com.token.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TokenApplication {	
	
	public static void main(String[] args) {
		SpringApplication.run(TokenApplication.class, args);	
	}

}
