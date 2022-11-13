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
@Table(name = "notice_details")
public class Notices {

    @Id
    @Column(name = "notice_id")
    private Long noticeId;
    private String noticeSummary;
    private String noticeDetails;
    private Date noticeBegDt;
    private Date noticeEndDt;
    private Date createDt;
    private Date updatedDt;
}
