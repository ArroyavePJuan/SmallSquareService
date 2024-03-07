package com.example.smallsquareservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SmallsquareServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmallsquareServiceApplication.class, args);
	}

}
