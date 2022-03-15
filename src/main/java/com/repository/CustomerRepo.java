package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	//Customer findById(int cid);
	
	//Customer deleteById(int cid);
	
	Customer findByCemailAndCpassword(String email, String pwd);

}
