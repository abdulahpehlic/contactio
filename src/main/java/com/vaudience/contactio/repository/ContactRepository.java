package com.vaudience.contactio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vaudience.contactio.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
  public Contact findByAddressPostalCode(String zipCode);
  
}
