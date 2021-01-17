package com.mc_shares.repository;

import com.mc_shares.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findByUsernameAndPassword(String username, String password);
    UserProfile findByUsername(String username);
    boolean existsByUsername(String username);
}
