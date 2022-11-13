package com.mbadady.EazyBank.repository;

import com.mbadady.EazyBank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmail(String email);

    Boolean existsByEmail(String email);
}
