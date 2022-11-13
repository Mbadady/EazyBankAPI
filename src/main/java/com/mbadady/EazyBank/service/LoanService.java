package com.mbadady.EazyBank.service;

import com.mbadady.EazyBank.entity.Loans;

import java.util.List;

public interface LoanService {

    List<Loans> getLoanDetails(Long customerId);
}
