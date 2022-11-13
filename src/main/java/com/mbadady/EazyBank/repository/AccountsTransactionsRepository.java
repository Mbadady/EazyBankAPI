package com.mbadady.EazyBank.repository;

import com.mbadady.EazyBank.entity.AccountsTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountsTransactionsRepository extends JpaRepository<AccountsTransactions, String> {
  List<AccountsTransactions> findByCustomerIdOrderByTransactionDateDesc(Long customerId);
}
