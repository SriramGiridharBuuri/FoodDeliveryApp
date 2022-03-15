package com.service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Customer;
import com.entity.Login;
import com.entity.RestaurantOwner;
import com.advices.LoginNotFoundException;
import com.repository.CustomerRepo;
import com.repository.RestaurantOwnerRepo;
@Service
public class LoginService {
//	@Autowired
//	LoginRepository loginrepository;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	RestaurantOwnerRepo restaurantOwnerRepo;
	
	
	public String addLogin(Login b)
	{
		if(b.isCustomer()) {
			Customer customer = customerRepo.findByCemailAndCpassword(b.getEmail(), b.getPassword());
			if(customer != null) {
				return "Login success";
			}
			
		} else {
			RestaurantOwner restaurantOwner = restaurantOwnerRepo.findByEmailAndPassword(b.getEmail(), b.getPassword());
			if(restaurantOwner != null) {
				return "Login success";
			}
		}
		return "Login failed";
	}
	
//	public String deleteLogin(Login b)
//	{
//		loginrepository.delete(b);
//		return "Delete Successfully";
//	}
//	public Login updateLogin(Login b) throws Throwable 
//	{
//		Supplier s1 = ()-> new LoginNotFoundException("Id does not Exists");
//		int id = b.getId();
//		Login b1=loginrepository.findById(id).orElseThrow(s1);
//		b1.setEmail(b1.getEmail());
//		b1.setPassword(b1.getPassword());
//		loginrepository.save(b1);
//		return b1;
//	}
//	public Login getById(int id) throws Throwable
//	{
//		Supplier s1= () -> new LoginNotFoundException("Id not found /Incorrect Id");
//		Login b=loginrepository.findById(id).orElseThrow(s1);
//		return b;
//	}
//	public String deleteLoginById(int id) throws Throwable
//	{
//		Supplier s1= () -> new LoginNotFoundException("Id not found /Incorrect Id");
//		loginrepository.deleteById(id);
//		return "Delete Successfully";
//	}
}


