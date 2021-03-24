package com.vaudience.contactio.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

class ContactTest {


	@Autowired
    private MockMvc mvc;
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
		mvc.perform(get("/api/v1/contacts")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(content()
			      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			      .andExpect(jsonPath("$[0].name", is("bob")));
	}
}
