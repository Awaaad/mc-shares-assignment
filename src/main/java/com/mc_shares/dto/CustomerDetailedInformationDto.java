package com.mc_shares.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDetailedInformationDto {
    private String id;
    private String customerName;
    private Date dateOfBirth;
    private String customerType;
    private Long numberOfShares;
    private Double sharePricePerUnit;
    private Double balance;
}
