package com.mbadady.EazyBank.service.impl;

import com.mbadady.EazyBank.entity.Accounts;
import com.mbadady.EazyBank.repository.AccountsRepository;
import com.mbadady.EazyBank.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImpl implements AccountsService {

    private AccountsRepository accountsRepository;

    @Autowired
    public AccountsServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    @Override
    public Accounts getAccountDetails(Long customerId) {
        Accounts accounts = accountsRepository.findByCustomerId(customerId);
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }
}
