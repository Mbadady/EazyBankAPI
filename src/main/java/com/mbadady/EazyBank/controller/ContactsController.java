package com.mbadady.EazyBank.controller;


import com.mbadady.EazyBank.entity.Contact;
import com.mbadady.EazyBank.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @PostMapping("/contacts")
    public Contact saveContactDetails(@RequestBody Contact contact){
        return contactsService.getContactsAndSave(contact);
    }
}
