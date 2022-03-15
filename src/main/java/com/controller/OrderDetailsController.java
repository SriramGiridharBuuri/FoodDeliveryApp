package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.OrderDetails;
import com.service.OrderDetailsService;

@RestController
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@PostMapping("/addorderhistory")
	public ResponseEntity<OrderDetails> addOrder(@RequestBody OrderDetails od) {
		OrderDetails od1 = orderDetailsService.addOrderDetails(od);
		ResponseEntity<OrderDetails> ro = new ResponseEntity<OrderDetails>(od1,HttpStatus.OK);
		return ro;
		
	}
	
	@DeleteMapping("/deleteOrderHistory")
	public String deleteDetails() {
		orderDetailsService.deleteOrderDetails();
		return "Order Details deleted Successfully";
	}
}
