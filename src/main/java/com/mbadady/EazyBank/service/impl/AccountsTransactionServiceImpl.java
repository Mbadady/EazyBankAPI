package com.mbadady.EazyBank.service.impl;

import com.mbadady.EazyBank.entity.AccountsTransactions;
import com.mbadady.EazyBank.repository.AccountsTransactionsRepository;
import com.mbadady.EazyBank.service.AccountsTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountsTransactionServiceImpl implements AccountsTransactionService {


    private AccountsTransactionsRepository accountsTransactionsRepository;

    @Autowired
    public AccountsTransactionServiceImpl(AccountsTransactionsRepository accountsTransactionsRepository) {
        this.accountsTransactionsRepository = accountsTransactionsRepository;
    }

    @Override
    public List<AccountsTransactions> getBalanceDetails(Long customerId) {
       List<AccountsTransactions> accountsTransactions = accountsTransactionsRepository.findByCustomerIdOrderByTransactionDateDesc(customerId);

       if(accountsTransactions != null){
           return accountsTransactions;
       }else {
           return null;
       }
    }
}
