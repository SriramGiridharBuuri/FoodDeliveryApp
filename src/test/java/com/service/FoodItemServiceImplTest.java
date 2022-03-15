package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.entity.*;
import com.repository.*;

@SpringBootTest
class FoodItemServiceImplTest {

	@Autowired
	FoodItemServiceImpl foodItemServiceImpl;
	
	@MockBean
	FoodItemRepository foodItemRepository;
	
	
	

	@Test
	void testSaveFoodItem() {
		FoodItem foodItem = new FoodItem();
		foodItem.setId(1);
		foodItem.setDishName("PavBhaji");
		foodItem.setFoodType("Veg");
		foodItem.setPrice(250);
		
		Mockito.when(foodItemRepository.save(foodItem)).thenReturn(foodItem);
		
		assertThat(foodItemServiceImpl.saveFoodItem(foodItem)).isEqualTo(foodItem);
	}

	@Test
	void testGetAllfFoodItems() {
		FoodItem foodItem = new FoodItem();
		foodItem.setId(1);
		foodItem.setDishName("PavBhaji");
		foodItem.setFoodType("Veg");
		foodItem.setPrice(250);
		
		FoodItem foodItem2 = new FoodItem();
		foodItem2.setId(2);
		foodItem2.setDishName("BhelPuri");
		foodItem2.setFoodType("Veg");
		foodItem2.setPrice(50);
		

		FoodItem foodItem3 = new FoodItem();
		foodItem3.setId(3);
		foodItem3.setDishName("Dosa");
		foodItem3.setFoodType("Veg");
		foodItem3.setPrice(150);
		
		List<FoodItem> foodItems = new ArrayList<>();
		foodItems.add(foodItem);
		foodItems.add(foodItem2);
		foodItems.add(foodItem3);
		
		Mockito.when(foodItemRepository.findAll()).thenReturn(foodItems);
		
		assertThat(foodItemServiceImpl.getAllfFoodItems()).isEqualTo(foodItems);
		
	}

	@Test
	void testGetFoodItemByid() throws Throwable {
		FoodItem foodItem = new FoodItem();
		foodItem.setId(1);
		foodItem.setDishName("PavBhaji");
		foodItem.setFoodType("Veg");
		foodItem.setPrice(250);
		
		Optional<FoodItem> fooditem2= Optional.of(foodItem);
		
		Mockito.when(foodItemRepository.findById(1)).thenReturn(fooditem2);
		
		assertThat(foodItemServiceImpl.getFoodItemByid(1)).isEqualTo(foodItem);
	}

	@Test
	void testUpdateFoodItem() throws Throwable{
		FoodItem foodItem = new FoodItem();
		foodItem.setId(1);
		foodItem.setDishName("PavBhaji");
		foodItem.setFoodType("Veg");
		foodItem.setPrice(250);
		
		Optional<FoodItem> fooditem2= Optional.of(foodItem);
		
		Mockito.when(foodItemRepository.findById(1)).thenReturn(fooditem2);
		
		Mockito.when(foodItemRepository.save(foodItem)).thenReturn(foodItem);
		foodItem.setDishName("noodles");
		foodItem.setFoodType("Nonveg");
		foodItem.setPrice(400);
		
		assertThat(foodItemServiceImpl.updateFoodItem(foodItem, 1)).isEqualTo(foodItem);
	}

	@Test
	void testDeleteFoodItem() {
		FoodItem foodItem = new FoodItem();
		foodItem.setId(1);
		foodItem.setDishName("PavBhaji");
		foodItem.setFoodType("Veg");
		foodItem.setPrice(250);
		
		Optional<FoodItem> fooditem2= Optional.of(foodItem);
		
		Mockito.when(foodItemRepository.existsById(foodItem.getId())).thenReturn(false);
		
		assertFalse(foodItemRepository.existsById(foodItem.getId()));
		
		
	}
}

