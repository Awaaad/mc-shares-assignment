package com.mc_shares.service;

import com.mc_shares.dto.UserDto;
import com.mc_shares.entity.UserProfile;

import java.util.List;

public interface UserService {
    // Get
    UserDto findUserById (Long userId);

    UserDto findUserByUsernameAndPassword (String username, String password);

    UserDto findUserByUsername(String username);

    List<UserDto> findAllUsers();

    // Post
    void saveUser (UserDto userDto);

    void saveUser(UserProfile userProfile);

    void saveUsers(List<UserProfile> userProfiles);
}
