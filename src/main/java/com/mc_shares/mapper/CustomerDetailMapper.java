package com.mc_shares.mapper;

import com.mc_shares.dto.CustomerDetailDto;
import com.mc_shares.entity.CustomerDetail;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        ContactDetailMapper.class,
        MailingAddressMapper.class,
        SharesDetailMapper.class
    }
)
public interface CustomerDetailMapper {
    @Mapping(target = "sharesDetailDto", source = "sharesDetails")
    @Mapping(target = "mailingAddressDto", source = "mailingAddresses")
    @Mapping(target = "contactDetailDto", source = "contactDetail")
    CustomerDetailDto mapCustomerDetailEntityToDto(CustomerDetail customerDetail);
    @InheritInverseConfiguration
    CustomerDetail mapCustomerDetailDtoToEntity(CustomerDetailDto customerDetailDto);
}
