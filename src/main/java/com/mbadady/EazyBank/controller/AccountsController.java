package com.mbadady.EazyBank.controller;

import com.mbadady.EazyBank.entity.Accounts;
import com.mbadady.EazyBank.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @GetMapping("/accounts")
    public Accounts getAccountDetails(@PathVariable Long id){
        return accountsService.getAccountDetails(id);
    }
}
