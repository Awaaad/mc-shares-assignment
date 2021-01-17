package com.mc_shares.service;

import com.mc_shares.dto.RoleDto;
import com.mc_shares.entity.Role;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAllRoles();

    void saveRole(RoleDto roleDto);

    void saveRoles(List<Role> roles);
}
