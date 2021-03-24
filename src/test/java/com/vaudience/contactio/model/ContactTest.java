package com.vaudience.contactio.model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testConstructor() {
		Date testDate = new Date();
		Address testAddress = new Address("Würzburg", "97082");
		Contact testContact = new Contact("Abdulah", testDate, testAddress);
		assertEquals("Abdulah", testContact.getFullName());
		assertEquals(testDate, testContact.getBirthDate());
		assertEquals("Würzburg", testContact.getAddress().getCity());
		assertEquals("97082", testContact.getAddress().getPostalCode());
	}
	
	@Test
	void testDefaultConstructor() throws Exception {
		Contact testContact = new Contact();
		assertNull(testContact.getFullName());
		assertNull(testContact.getBirthDate());
		assertNull(testContact.getAddress());
	}
}
