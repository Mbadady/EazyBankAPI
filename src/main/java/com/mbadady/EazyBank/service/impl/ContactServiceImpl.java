package com.mbadady.EazyBank.service.impl;

import com.mbadady.EazyBank.entity.Contact;
import com.mbadady.EazyBank.repository.ContactsRepository;
import com.mbadady.EazyBank.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class ContactServiceImpl implements ContactsService {


    private ContactsRepository contactsRepository;

    @Autowired
    public ContactServiceImpl(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @Override
    public Contact getContactsAndSave(Contact contact) {
        contact.setContactId(getServiceReqNum());
        contact.setCreatedDt(new Date(System.currentTimeMillis()));

        return contactsRepository.save(contact);
    }
    public String getServiceReqNum(){
        Random random = new Random();
        int ranNum = random.nextInt(999999999-9999) + 9999;
        return "SR "+ ranNum;
    }
}
