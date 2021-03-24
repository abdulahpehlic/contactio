package com.vaudience.contactio.model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddressTest {

	@Test
	public void constructorTest() {
		Address testAddress = new Address("Würzburg", "97082");
		assertEquals(testAddress.getCity(), "Würzburg");
		assertEquals(testAddress.getPostalCode(), "97082");
	}
	
	@Test
	public void defaultConstructorTest() {
		Address testAddress = new Address();
		assertNull(testAddress.getCity());
		assertNull(testAddress.getPostalCode());
	}
}
