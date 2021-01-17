package com.mc_shares.repository;

import com.mc_shares.entity.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDetailRepository extends JpaRepository<ContactDetail, Long> {
}
