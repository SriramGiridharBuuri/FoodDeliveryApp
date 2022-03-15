package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
	
	//Restaurant findById(int rid);
	
	//Restaurant deleteById(int rid);
	
	//@Query("select r from restaurant r where r.raddress=?1 order by r.rname")
	List<Restaurant> findByRaddress(String raddress);
	
	List<Restaurant> findByRname(String rname);

}
