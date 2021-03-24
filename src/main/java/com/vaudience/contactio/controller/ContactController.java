package com.vaudience.contactio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaudience.contactio.model.Contact;
import com.vaudience.contactio.repository.ContactRepository;

@RestController
@RequestMapping("/api/v1")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;


    @GetMapping("/contacts")
    public List <Contact> getContacts() {
        return (List<Contact>) contactRepository.findAll();
    }
    
    @GetMapping("/contacts/postalCode")
    @ResponseBody
    public ResponseEntity<Contact> getContactByZipCode(@RequestParam(name = "postalCode") String postalCode) {
    	Contact contact = contactRepository.findByAddressPostalCode(postalCode);
        return ResponseEntity.ok().body(contact);
    }

    @PostMapping("/contacts")
    public Contact createContact(@Valid @RequestBody Contact contact) {
        return contactRepository.save(contact);
    }
}