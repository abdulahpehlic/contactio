package com.vaudience.contactio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactioApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactioApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ContactioApplication.class, args);
	}
}
