package com.vaudience.contactio;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vaudience.contactio.model.Address;
import com.vaudience.contactio.model.Contact;
import com.vaudience.contactio.repository.ContactRepository;

@SpringBootApplication
public class ContactioApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactioApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ContactioApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ContactRepository contactRepository) {
		Contact contact = new Contact("Abdulah", new Date());

        Address address = new Address("Sarajevo", "71000");

        // associate the objects
        contact.setAddress(address);

        contactRepository.save(contact);
		return null;
	}
}
