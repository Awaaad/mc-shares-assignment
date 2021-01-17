package com.mc_shares.dto;

import lombok.Data;

@Data
public class AuthenticatedUserDto {
    private UserDto userDto;
    private String token;
}
