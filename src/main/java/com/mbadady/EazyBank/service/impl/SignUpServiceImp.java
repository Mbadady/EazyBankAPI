package com.mbadady.EazyBank.service.impl;

import com.mbadady.EazyBank.entity.Customer;
import com.mbadady.EazyBank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SignUpServiceImp {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> userSignUp(Customer customer) {
//
        if (customerRepository.existsByEmail(customer.getEmail())) {
            return new ResponseEntity<>("User Already Exists", HttpStatus.BAD_REQUEST);
        }
        try {
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//            customer.setCreatedAt(String.valueOf(new Date(System.currentTimeMillis())));
            customerRepository.save(customer);

            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);

        } catch (Exception exception) {
            return new ResponseEntity<>("An Exception Occurred due to " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//
        }
    }

    public Customer getUserDetailsAfterLogin(Authentication authentication){

        List<Customer> customers = customerRepository.findByEmail(authentication.getName());

        if(customers.size() > 0){
            return customers.get(0);
        }
        return null;
    }
}
