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
@Table(name = "accounts")
public class Accounts {

    @Id
    @Column(name = "accounts")
    private  String accountNumber;
    private Long customerId;
    private String accountType;
    private String branchAddress;
    private Date createDate;

}
