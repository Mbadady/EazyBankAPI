package com.mbadady.EazyBank.service;

import com.mbadady.EazyBank.entity.Contact;

public interface ContactsService {
    Contact getContactsAndSave(Contact contact);
}
