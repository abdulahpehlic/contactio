package com.vaudience.contactio.model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class ContactTest {

	@Test
	public void constructorTest() {
		Date testDate = new Date();
		Address testAddress = new Address("Würzburg", "97082");
		Contact testContact = new Contact("Abdulah", testDate, testAddress);
		assertEquals(testContact.getFullName(), "Abdulah");
		assertEquals(testContact.getBirthDate(), testDate);
		assertEquals(testContact.getAddress().getCity(), "Würzburg");
		assertEquals(testContact.getAddress().getPostalCode(), "97082");
	}
	
	@Test
	public void defaultConstructorTest() throws Exception {
		Contact testContact = new Contact();
		assertNull(testContact.getFullName());
		assertNull(testContact.getBirthDate());
		assertNull(testContact.getAddress());
	}
}
