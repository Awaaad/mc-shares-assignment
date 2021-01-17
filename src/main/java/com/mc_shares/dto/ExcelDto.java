package com.mc_shares.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ExcelDto {

    private String customerDetailId;
    private String customerType;
    private Date dateOfBirth;
    private Date dateIncorp;
    private String registrationNumber;

    public ExcelDto(String customerDetailId, String customerType, Date dateOfBirth, Date dateIncorp, String registrationNumber) {
        this.customerDetailId = customerDetailId;
        this.customerType = customerType;
        this.dateOfBirth = dateOfBirth;
        this.dateIncorp = dateIncorp;
        this.registrationNumber = registrationNumber;
    }
}