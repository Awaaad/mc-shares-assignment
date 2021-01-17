package com.mc_shares.dto;

import lombok.Data;

@Data
public class MailingAddressDto {
    private Long mailingAddressId;
    private String addressLineOne;
    private String addressLineTwo;
    private String townCity;
    private String country;
}
