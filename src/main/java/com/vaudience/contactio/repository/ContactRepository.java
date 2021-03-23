package com.vaudience.contactio.repository;

import org.springframework.data.repository.CrudRepository;

import com.vaudience.contactio.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	
  public Contact findByAddress_PostalCode(String zipCode);
  
}
