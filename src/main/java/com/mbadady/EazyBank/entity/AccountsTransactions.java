package com.mbadady.EazyBank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts_transactions")
public class AccountsTransactions {

    @Id
    @Column(name = "transaction_id")
    private String TransactionId;
    private String accountNumber;
    private String transactionSummary;
    private Long customerId;
    private Date transactionDate;
    private String transactionType;
    private String transactionAmt;
}
