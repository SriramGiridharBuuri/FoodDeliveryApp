package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.BillingAddress;
@Repository
public interface BiilingRepo extends JpaRepository<BillingAddress, Integer> {
	//BillingAddress findById(int cid);
	//BillingAddress deleteById(int cid);
}
