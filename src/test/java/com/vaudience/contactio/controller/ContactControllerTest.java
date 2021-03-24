package com.vaudience.contactio.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

class ContactControllerTest {
	
	@Autowired
    private MockMvc mvc;

	@Test
	void test() throws Exception {
	    mvc.perform(get("/api/v1/contacts")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	}
}


