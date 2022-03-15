package com.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Address;




@Repository
public interface OrderRepository extends JpaRepository<Address, Integer> {

	//Address findById(int cid);

	
	//Address deleteById(int cid);

	}

