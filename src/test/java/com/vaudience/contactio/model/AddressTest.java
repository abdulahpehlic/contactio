package com.vaudience.contactio.model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AddressTest {

	@Test
	void testConstructor() {
		Address testAddress = new Address("Würzburg", "97082");
		assertEquals("Würzburg", testAddress.getCity());
		assertEquals("97082", testAddress.getPostalCode());
	}
	
	@Test
	void testDefaultConstructor() {
		Address testAddress = new Address();
		assertNull(testAddress.getCity());
		assertNull(testAddress.getPostalCode());
	}
}
