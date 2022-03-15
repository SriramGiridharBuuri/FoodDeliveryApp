package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.entity.FoodItem;



@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>{

	public List<FoodItem> findByFoodTypeIgnoreCase (String foodType);
}
