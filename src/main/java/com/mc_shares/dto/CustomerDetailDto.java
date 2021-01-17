package com.mc_shares.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class CustomerDetailDto {
    private String customerDetailId;
    private String customerType;
    private Date dateOfBirth;
    private Date dateIncorp;
    private String registrationNumber;
    private ContactDetailDto contactDetailDto;
    private MailingAddressDto mailingAddressDto;
    private SharesDetailDto sharesDetailDto;
}
