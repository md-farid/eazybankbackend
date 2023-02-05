package com.teamwebsoft.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Table(name = "notice_details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private long noticeId;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notice_beg_dt")
    private Date noticeBegDt;

    @Column(name = "notice_end_dt")
    private Date noticeEndDt;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
