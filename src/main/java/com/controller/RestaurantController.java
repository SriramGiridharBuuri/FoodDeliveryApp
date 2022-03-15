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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Restaurant;
import com.service.RestaurantService;

@RestController
@RequestMapping("/apirc")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	@PostMapping("/addRestaurant")
	public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody Restaurant r) {

		Restaurant r1 = restaurantService.addRestaurant(r);
		ResponseEntity<Restaurant> rr = new ResponseEntity<Restaurant>(r1, HttpStatus.OK);
		return rr;
	}

	@GetMapping("/getbyid/{rid}")
	public ResponseEntity<Restaurant> getById(@Valid @PathVariable int rid) throws Throwable {
		Restaurant r1 = restaurantService.getById(rid);
		ResponseEntity<Restaurant> rr = new ResponseEntity<Restaurant>(r1, HttpStatus.OK);
		return rr;
	}

	@DeleteMapping("/detelebyid/{rid}")
	public String deleteRestaurantById(@Valid @PathVariable int rid) {
		restaurantService.deleteRestaurantById(rid);
		return "Row Deleted Successfully";
	}

//	@DeleteMapping("/deleterestaurant")
//	public String deleteRestaurant(@Valid @RequestBody Restaurant r) {
//		restaurantService.deleteRestaurant(r);
//		return "Records Deleted Successfully";
//	}

	@GetMapping("/getNearestRestaurant/{raddress}")
	public ResponseEntity<List<Restaurant>> getRestaurants(@Valid @PathVariable String raddress) {
		List<Restaurant> r = restaurantService.getNearestRestaurant(raddress);
		ResponseEntity<List<Restaurant>> r1 = new ResponseEntity<List<Restaurant>>(r, HttpStatus.OK);
		return r1;
	}
	
	@GetMapping("/getRestaurant/{rname}")
	public ResponseEntity<List<Restaurant>> getRestaurant(@Valid @PathVariable String rname) {
		List<Restaurant> r = restaurantService.getRestaurantByName(rname);
		ResponseEntity<List<Restaurant>> r1 = new ResponseEntity<List<Restaurant>>(r, HttpStatus.OK);
		return r1;
	}

}
