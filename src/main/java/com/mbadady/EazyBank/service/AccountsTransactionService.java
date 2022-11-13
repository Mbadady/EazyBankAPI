package com.mbadady.EazyBank.service;

import com.mbadady.EazyBank.entity.AccountsTransactions;

import java.util.List;

public interface AccountsTransactionService {

    List<AccountsTransactions> getBalanceDetails(Long customerId);
}
