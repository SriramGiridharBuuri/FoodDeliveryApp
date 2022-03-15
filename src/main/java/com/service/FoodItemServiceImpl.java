package com.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.*;
import com.entity.*;
import com.repository.*;

@Service
public class FoodItemServiceImpl{
	
	@Autowired
	 private FoodItemRepository foodItemRepository;
	
	public FoodItemServiceImpl(FoodItemRepository foodItemRepository) {
		super();
		this.foodItemRepository = foodItemRepository;
	}

	public FoodItem saveFoodItem(FoodItem foodItem) {
		return foodItemRepository.save(foodItem);
	}

	public List<FoodItem> getAllfFoodItems() {
		return foodItemRepository.findAll();
	}

	public FoodItem getFoodItemByid(int id) throws Exception {
		return foodItemRepository.findById(id).orElseThrow(()-> new FoodItemNotFoundException("food item not found"));
	}

	public FoodItem updateFoodItem(FoodItem foodItem,int id) throws Throwable {
		FoodItem exefoodItem = foodItemRepository.findById(id).orElseThrow(
				()-> new FoodItemNotFoundException("Food Item not found"));
		exefoodItem.setDishName(foodItem.getDishName());
		exefoodItem.setFoodType(foodItem.getFoodType());
		exefoodItem.setPrice(foodItem.getPrice());
		
		//save existing food item to datbase
		foodItemRepository.save(exefoodItem);
		return exefoodItem;
	}

	public void deleteFoodItem(int id) throws Throwable {
		// check  whether food item exist in database or not
				foodItemRepository.findById(id).orElseThrow(()-> 
				                              new FoodItemNotFoundException("food item not found"));
			
				foodItemRepository.deleteById(id);
		
	}

	public List<FoodItem> findByFoodType(String foodType) {
		// TODO Auto-generated method stub
		return foodItemRepository.findByFoodTypeIgnoreCase(foodType);
	}




}
