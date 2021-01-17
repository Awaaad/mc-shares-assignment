package com.mc_shares.mapper;

import com.mc_shares.dto.RoleDto;
import com.mc_shares.entity.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto mapRoleEntityToDto (Role roleEntity);
    @InheritInverseConfiguration
    Role mapRoleDtoToEntity (RoleDto roleDto);
}
