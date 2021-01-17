package com.mc_shares.dto;

import com.mc_shares.entity.CustomerDetail;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SharesDetailDto {
    private Long sharesDetailId;
    private Long numShares;
    private Double sharePrice;
}
