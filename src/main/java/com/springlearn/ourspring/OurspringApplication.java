package com.springlearn.ourspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.springlearn.ourspring", "com.springlearn.utils"})
public class OurspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(OurspringApplication.class, args);
	}

}
