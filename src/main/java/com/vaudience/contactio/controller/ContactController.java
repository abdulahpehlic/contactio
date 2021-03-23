package com.vaudience.contactio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/contacts")
    public Contact createContact(@Valid @RequestBody Contact contact) {
        return contactRepository.save(contact);
    }
}