package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.RestaurantNotFoundException;
import com.entity.RestaurantOwner;
import com.repository.RestaurantOwnerRepo;

@Service
public class RestaurantOwnerService {
	
	@Autowired
	private RestaurantOwnerRepo restaurantOwnerRepo;
	
	public RestaurantOwner addOwner(RestaurantOwner ro) {
		restaurantOwnerRepo.save(ro);
		return ro;
	}
	
	public RestaurantOwner getOwner(int rid) throws Throwable {
		Supplier s1 = ()-> new RestaurantNotFoundException("Name not found/Didn't Exists");
		RestaurantOwner ro = restaurantOwnerRepo.findById(rid).orElseThrow(s1);
		return ro;
	}
	
	public List<RestaurantOwner> getOwners() {
		List<RestaurantOwner> ro = restaurantOwnerRepo.findAll();
		return ro;
	}
	
	public RestaurantOwner updateOwner(RestaurantOwner ro) throws Throwable {
		int id = ro.getId();
		Supplier s1 = ()-> new RestaurantNotFoundException("Id Does not Exists");
		RestaurantOwner ro1 = restaurantOwnerRepo.findById(id).orElseThrow(s1);
		ro1.setOwnername(ro.getOwnername());
		ro1.setPhone(ro.getPhone());
		ro1.setPassword(ro.getPassword());
		restaurantOwnerRepo.save(ro1);
		return ro1;
		
	}
	
	public String deleteOwnerById(int rid) {
		restaurantOwnerRepo.deleteById(rid);
		return "Deleted Successfully";
		
	}

}
