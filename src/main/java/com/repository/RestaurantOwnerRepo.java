package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.RestaurantOwner;

@Repository
public interface RestaurantOwnerRepo extends JpaRepository<RestaurantOwner, Integer>{
	
	//RestaurantOwner findById(int rid);
	
	//@Query("select ro from restaurant_owner ro where ro.rid = ?1 ")
	
	RestaurantOwner findByEmailAndPassword(String email, String pwd)
;	
	

}
