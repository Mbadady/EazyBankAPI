package com.mbadady.EazyBank.controller;


import com.mbadady.EazyBank.entity.Loans;
import com.mbadady.EazyBank.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanService loanService;


    @GetMapping("/loans")
    public List<Loans> getLoanDetails(@RequestParam Long customerId){
        return loanService.getLoanDetails(customerId);
    }
}
