package com.mbadady.EazyBank.repository;

import com.mbadady.EazyBank.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsRepository extends JpaRepository<Contact, String> {
}
