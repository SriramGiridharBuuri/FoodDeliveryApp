package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.RestaurantNotFoundException;
import com.entity.Restaurant;
import com.repository.RestaurantRepo;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepo restaurantRepo;
	
	public Restaurant addRestaurant(Restaurant r) {
		restaurantRepo.save(r);
		return r;
	}
	
	public String deleteRestaurant(Restaurant r) {
		restaurantRepo.delete(r);
		return "Deleted successfully";
	}
	
	public Restaurant updateRestaurant(Restaurant r) throws Throwable {
		
		Supplier s1 = ()-> new RestaurantNotFoundException("Id does not Exists");
		int id = r.getRid();
		Restaurant r1 = restaurantRepo.findById(id).orElseThrow(s1);
		r1.setRname(r1.getRname());
		r1.setRaddress(r1.getRaddress());
		restaurantRepo.save(r1);
		return r1;
		
	}
	
	public Restaurant getById(int rid) throws Throwable {
		Supplier s1 = ()-> new RestaurantNotFoundException("Id not found/InCorrect Id");
		Restaurant r = restaurantRepo.findById(rid).orElseThrow(s1);
		return r;
	}
	
	public String deleteRestaurantById(int rid) {
		restaurantRepo.deleteById(rid);
		return "Row Deleted Successfully";
	}
	
	public List<Restaurant> getNearestRestaurant(String raddress) {
		List<Restaurant> r1 = restaurantRepo.findByRaddress(raddress);
			return r1;
	}
	
	public List<Restaurant> getRestaurantByName(String rname) {
		List<Restaurant> r1 = restaurantRepo.findByRname(rname);
		return r1;
	}
}
