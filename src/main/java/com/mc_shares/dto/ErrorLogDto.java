package com.mc_shares.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ErrorLogDto {
    private Long errorLogId;
    private String errorCode;
    private String customerDetailId;
    private String errorMessage;
}
