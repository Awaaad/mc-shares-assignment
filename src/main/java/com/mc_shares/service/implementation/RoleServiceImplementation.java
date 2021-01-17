package com.mc_shares.service.implementation;

import com.mc_shares.repository.RoleRepository;
import com.mc_shares.service.RoleService;
import com.mc_shares.dto.RoleDto;
import com.mc_shares.entity.Role;
import com.mc_shares.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImplementation implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImplementation(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDto> findAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::mapRoleEntityToDto).collect(Collectors.toList());
    }

    @Override
    public void saveRole(RoleDto roleDto) {
        var saveRoleInformation = roleMapper.mapRoleDtoToEntity(roleDto);
        roleRepository.save(saveRoleInformation);
    }

    @Override
    public void saveRoles(List<Role> roles) {
        roles.stream().map(role -> {
            if (!roleRepository.existsRoleByRole(role.getRole())) {
                roleRepository.save(role);
                return role;
            } else {
                return null;
            }
        }).collect(Collectors.toList());
    }
}
