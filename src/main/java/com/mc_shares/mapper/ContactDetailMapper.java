package com.mc_shares.mapper;

import com.mc_shares.dto.ContactDetailDto;
import com.mc_shares.entity.ContactDetail;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactDetailMapper {
    ContactDetailDto mapContactDetailEntityToDto(ContactDetail contactDetail);
    @InheritInverseConfiguration
    ContactDetail mapContactDetailDtoToEntity(ContactDetailDto contactDetailDto);
}
