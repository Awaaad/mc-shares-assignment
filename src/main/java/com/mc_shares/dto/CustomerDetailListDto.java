package com.mc_shares.dto;

import com.mc_shares.entity.CustomerDetail;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDetailListDto extends PaginationDto {
    private List<CustomerDetailDto> customerDetailsDto;
}
