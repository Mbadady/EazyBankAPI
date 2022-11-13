package com.mbadady.EazyBank.service.impl;

import com.mbadady.EazyBank.entity.Loans;
import com.mbadady.EazyBank.repository.LoansRepository;
import com.mbadady.EazyBank.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    private LoansRepository loansRepository;

    @Autowired
    public LoanServiceImpl(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }

    @Override
    public List<Loans> getLoanDetails(Long customerId) {
        List<Loans> loan = loansRepository.findByCustomerIdOrderByStartDtDesc(customerId);

        if(loan != null){
            return loan;
        }
        return null;
    }
}
