package com.mc_shares.mapper;

import com.mc_shares.dto.MailingAddressDto;
import com.mc_shares.entity.MailingAddress;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MailingAddressMapper {
    MailingAddressDto mapMailingAddressEntityToDto(MailingAddress mailingAddress);
    @InheritInverseConfiguration
    MailingAddress mapMailingAddressDtoToEntity(MailingAddressDto mailingAddressDto);
}
