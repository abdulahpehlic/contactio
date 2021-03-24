package com.vaudience.contactio.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaudience.contactio.model.Address;
import com.vaudience.contactio.model.Contact;
import com.vaudience.contactio.repository.ContactRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactController.class)
class ContactControllerTest {

	@MockBean
	private ContactRepository contactRepository;
	
	@Autowired
	private MockMvc mvc;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Test
	void testGetAllContacts() throws Exception {
		when(contactRepository.findAll()).thenReturn(null);
		mvc.perform(get("/api/v1/contacts")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	void testGetContactsByPostalCode() throws Exception {
		when(contactRepository.findByAddressPostalCode(Mockito.anyString())).thenReturn(null);
		mvc.perform(get("/api/v1/contacts/postalCode?postalCode=" + "71000")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	void testCreateContact() throws Exception {
		Date testDate = new Date();
		Address testAddress = new Address("Würzburg", "97082");
		Contact testContact = new Contact("Abdulah", testDate, testAddress);
		when(contactRepository.findByAddressPostalCode(Mockito.anyString())).thenReturn(null);
		mvc.perform(post("/api/v1/contacts/create")
				.content(objectMapper.writeValueAsString(testContact))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
