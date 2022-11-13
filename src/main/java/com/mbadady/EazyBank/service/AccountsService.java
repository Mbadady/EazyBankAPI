package com.mbadady.EazyBank.service;

import com.mbadady.EazyBank.entity.Accounts;

public interface AccountsService {

    Accounts getAccountDetails(Long customerId);
}
