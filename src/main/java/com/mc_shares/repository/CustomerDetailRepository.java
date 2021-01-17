package com.mc_shares.repository;

import com.mc_shares.entity.CustomerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CustomerDetailRepository extends JpaRepository<CustomerDetail, String>, QuerydslPredicateExecutor<CustomerDetail> {
}
