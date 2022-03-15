package com.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.entity.RestaurantOwner;
import com.service.RestaurantOwnerService;

@RestController
@RequestMapping("/apiroc")
public class RestaurantOwnerController {
	
	@Autowired
	private RestaurantOwnerService restaurantOwnerService;
	
	@PostMapping("/addowner")
	public ResponseEntity<RestaurantOwner> add(@RequestBody RestaurantOwner ro) {
		RestaurantOwner ro1 = restaurantOwnerService.addOwner(ro);
		ResponseEntity<RestaurantOwner> re = new ResponseEntity<RestaurantOwner>(ro1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getownerbyid/{rid}")
	public ResponseEntity<RestaurantOwner> get(@PathVariable int rid) throws Throwable {
		RestaurantOwner ro1 = restaurantOwnerService.getOwner(rid);
		ResponseEntity<RestaurantOwner> re = new ResponseEntity<RestaurantOwner>(ro1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getowners")
	public ResponseEntity<List<RestaurantOwner>> getowners() {
		List<RestaurantOwner> ro1 = restaurantOwnerService.getOwners();
		ResponseEntity<List<RestaurantOwner>> re = new ResponseEntity<List<RestaurantOwner>>(ro1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/updateOwner")
	public ResponseEntity<RestaurantOwner> updateOwner(@RequestBody RestaurantOwner ro) throws Throwable {
		RestaurantOwner ro1 = restaurantOwnerService.updateOwner(ro);
		ResponseEntity<RestaurantOwner> re = new ResponseEntity<RestaurantOwner>(ro1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping("/deleteById/{rid}")
	public String deleteById(@PathVariable int rid) {
		restaurantOwnerService.deleteOwnerById(rid);
		return "Row Deleted Successfully";
	}
}
