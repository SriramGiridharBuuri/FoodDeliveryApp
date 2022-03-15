package com.controller;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.entity.*;
import com.service.*;

@RestController
@RequestMapping("/apifi")
public class FoodItemController {

	@Autowired
	private FoodItemServiceImpl foodItemService;
	public FoodItemController(FoodItemServiceImpl foodItemService) {
		super();
		this.foodItemService = foodItemService;
	}

	// build add food item api
	
	@PostMapping("/addfooditem")
	public ResponseEntity<FoodItem> addFoodItem(@Valid @RequestBody FoodItem foodItem){
		return new ResponseEntity<FoodItem>(foodItemService.saveFoodItem(foodItem), HttpStatus.OK);
	}
	
	//build all fooditem rest api
	@GetMapping("/fooditems")
	public ResponseEntity<List<FoodItem>> getAllfFoodItems(){
		List<FoodItem> lc1 = foodItemService.getAllfFoodItems();
		ResponseEntity responseEntity = new ResponseEntity<List<FoodItem>>(lc1,HttpStatus.OK);
		return responseEntity;
	}
	
	// get food by id
	@GetMapping("/fooditems/{id}")
	public ResponseEntity<FoodItem> getFoodItemByid(@PathVariable("id") int foodid) throws Exception{
		return new ResponseEntity<FoodItem>(foodItemService.getFoodItemByid(foodid), HttpStatus.OK);
	}
	
	//build update food item rest api
    @PutMapping("/fooditems/{id}")
	public ResponseEntity<FoodItem> updateFoodItem(@Valid @PathVariable("id") int id,@RequestBody FoodItem foodItem) throws Throwable{
    	return new ResponseEntity<FoodItem>(foodItemService.updateFoodItem(foodItem, id),HttpStatus.OK);
		
	}
    
    //build delete food item
    @DeleteMapping("//fooditems/{id}")
    public ResponseEntity<String> deleteFoodItem(@PathVariable("id") int id) throws Throwable{
    	foodItemService.deleteFoodItem(id);//delete fooditem
    	
    	return new ResponseEntity<String>("Food item delted successfully", HttpStatus.OK);
    	
    }
    
    
    @GetMapping("/getbytype")
    public List<FoodItem> findByFoodType(@RequestParam String foodType) {
    	
    	return foodItemService.findByFoodType(foodType);
		
	}
    
 
}

