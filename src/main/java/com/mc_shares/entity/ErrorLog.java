package com.mc_shares.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class ErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ERROR_LOG_ID")
    private Long errorLogId;

    @Column(name = "ERROR_CODE")
    private String errorCode;

    @Column(name = "CUSTOMER_DETAIL_ID")
    private String customerDetailId;

    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;
}
