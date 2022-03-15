package com.entity;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "FoodMenu")
public class FoodItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private int id;
	
	@Pattern(regexp = "^[a-zA-Z0-9-]+$",message = "Only alphabates and numeric are allowed")
	@Column(name = "DishName")
	private String dishName;
	
	@Pattern(regexp = "^[a-zA-Z0-9-]+$",message = "'veg/nonveg' only these keywords allowed")
	@Size(min = 3,max = 6)
	@Column(name = "Type")
	private String foodType;
	
	@Column(name = "Price")
	private int price;
	
//	@ManyToOne
//    @JoinColumn(name="rid")
//	private Restaurant restaurant;
	
//	public Restaurant getRestaurant() {
//		return restaurant;
//	}
//
//	public void setRestaurant(Restaurant restaurant) {
//		this.restaurant = restaurant;
//	}

	public FoodItem() {
		
	}

	public FoodItem(int id, String dishName, String foodType, int price) {
		super();
		this.id = id;
		this.dishName = dishName;
		this.foodType = foodType;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FoodItem [id=" + id + ", dishName=" + dishName + ", foodType=" + foodType + ", price=" + price + "]";
	}
	
	
	

}
