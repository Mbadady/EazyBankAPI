package com.mbadady.EazyBank.controller;

import com.mbadady.EazyBank.dto.response.JwtResponseDto;
import com.mbadady.EazyBank.entity.Customer;
//import com.mbadady.EazyBank.filter.JwtTokenGenerator;
import com.mbadady.EazyBank.service.impl.SignUpServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class signUpController {

    @Autowired
    private SignUpServiceImp signUpServiceImp;

//    @Autowired
//    private JwtTokenGenerator jwtTokenGenerator;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Customer customer){
       return signUpServiceImp.userSignUp(customer);
    }

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication){

//    String jwt = jwtTokenGenerator.generateToken(authentication);
//
//    JwtResponseDto jwtResponseDto = new JwtResponseDto(jwt, "Bearer");
//
//    return new ResponseEntity<>(jwtResponseDto, HttpStatus.OK);

        return signUpServiceImp.getUserDetailsAfterLogin(authentication);
    }
}
