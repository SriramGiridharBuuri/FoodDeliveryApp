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

import com.entity.Customer;
import com.service.CustomerService;

@RestController
@RequestMapping("/apicc")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addRestaurant(@RequestBody Customer c) {
		
		Customer c1 = customerService.addCustomer(c);
		ResponseEntity<Customer> rr = new ResponseEntity<Customer>(c1,HttpStatus.OK);
		return rr;
	}
	
	@GetMapping("/getcustomerbyid/{cid}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int cid) throws Throwable {
		Customer c1 = customerService.getCustomerById(cid);
		ResponseEntity<Customer> rc = new ResponseEntity<Customer>(c1,HttpStatus.OK);
		return rc;
	}
	
	@GetMapping("/getcustomers")
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> c1 = customerService.getCustomers();
		ResponseEntity<List<Customer>> rc = new ResponseEntity<List<Customer>>(c1,HttpStatus.OK);
		return rc;
	}
	
	@DeleteMapping("/deletecustomerbyid/{cid}")
	public String deleteCustomerById(@PathVariable int cid) {
		customerService.deleteCustomerById(cid);
		return "Deleted Successful"; 
	}
	
	@PutMapping("/updatecustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c) throws Throwable {
		Customer c1 = customerService.updateCustomer(c);
		ResponseEntity<Customer> rc = new ResponseEntity<Customer>(c1,HttpStatus.OK);
		return rc;
	}
	

}

