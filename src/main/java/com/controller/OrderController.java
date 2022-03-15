package com.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.entity.Address;

import com.service.OrderService;
import java.util.List;
import javax.persistence.criteria.Order;
import javax.validation.Valid;

@RestController
@RequestMapping("/apioc")

public class OrderController {

   
	@Autowired
     OrderService orderservice;

   @PostMapping("/addorder")
   public ResponseEntity<Address> addOrder(@Valid @RequestBody Address c){
	   Address c1=orderservice.addOrderItem(c);
	   ResponseEntity<Address> cc= new ResponseEntity<Address>(c1,HttpStatus.OK);
	   return cc;
    }
   
	   @GetMapping("/getbyid/{cid}")
	public ResponseEntity<Address> getById(@Valid @PathVariable int cid) throws Throwable {
		Address c1 = orderservice.getById(cid);
		ResponseEntity<Address> cc = new ResponseEntity<Address>(c1,HttpStatus.OK);
		return cc;
	}
	
	@DeleteMapping("/detelebyid/{cid}")
	public String deleteById(@Valid @PathVariable int cid) throws Throwable {
		orderservice.deleteById(cid);
		return "Row Deleted Successfully";
	}
	
//	
//	@PutMapping("/updateorder")
//	public ResponseEntity<Address> updateAddress(@Valid @RequestBody Address c) throws Throwable {
//		Address c1 = orderservice.updateAddress(c);
//		ResponseEntity<Address> cc = new ResponseEntity<Address>(c1,HttpStatus.OK);
//		return cc;
//     }
}