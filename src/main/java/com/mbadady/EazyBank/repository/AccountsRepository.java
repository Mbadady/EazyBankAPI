package com.mbadady.EazyBank.repository;

import com.mbadady.EazyBank.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts, String> {

    Accounts findByCustomerId(Long customerId);
}
