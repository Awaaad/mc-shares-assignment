package com.mc_shares.mapper;

import com.mc_shares.dto.UserDto;
import com.mc_shares.entity.UserProfile;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto mapUserEntityToDto (UserProfile userProfileEntity);
    @InheritInverseConfiguration
    UserProfile mapUserDtoToEntity (UserDto userDto);
}
