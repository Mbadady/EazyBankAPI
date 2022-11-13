package com.mbadady.EazyBank.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @Column(name = "contact_Id")
    private String contactId;
    private Date createdDt;
    private String contactName;
    private String contactEmail;
    private String subject;
    private String message;
}
