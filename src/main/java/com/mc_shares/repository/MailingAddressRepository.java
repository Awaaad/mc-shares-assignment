package com.mc_shares.repository;

import com.mc_shares.entity.MailingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailingAddressRepository extends JpaRepository<MailingAddress, Long> {
}
