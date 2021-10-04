package com.example.mobilecharge.charge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.mobilecharge.charge"})
@EntityScan("com.example.mobilecharge.charge")
public class ChargeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChargeApplication.class, args);
	}

}
