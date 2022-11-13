package com.mbadady.EazyBank.controller;

import com.mbadady.EazyBank.entity.AccountsTransactions;
import com.mbadady.EazyBank.service.AccountsTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountsTransactionService accountsTransactionService;

    @GetMapping("/balance")
    public List<AccountsTransactions> getAccountbalance(@RequestParam Long customerId){
        return accountsTransactionService.getBalanceDetails(customerId);
    }
}
