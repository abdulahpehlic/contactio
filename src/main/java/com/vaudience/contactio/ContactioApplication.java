package com.vaudience.contactio;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vaudience.contactio.model.Address;
import com.vaudience.contactio.model.Contact;
import com.vaudience.contactio.repository.ContactRepository;

@SpringBootApplication
public class ContactioApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ContactioApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ContactRepository contactRepository) {

        Address address = new Address("Sarajevo", "71000");
        
		Contact contact = new Contact("Abdulah", new Date(), address);

        contactRepository.save(contact);
		return null;
	}
}
