package com.controller;


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

import com.entity.Login;
import com.service.LoginService;


@RestController
@RequestMapping("/apilogin")
public class LoginController {

	@Autowired
	LoginService loginservice;
	public LoginController(LoginService loginService)
	{
		super();
		this.loginservice=loginService;
	}
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Login b)
	{
		String b1= loginservice.addLogin(b);
		ResponseEntity<String> bb = new ResponseEntity<String>(b1,HttpStatus.OK);
		return bb;	
	}
//	@GetMapping("/getbyid/{id}")
//	public ResponseEntity<Login> getById(@PathVariable int id) throws Throwable
//	{
//		Login b1= loginservice.getById(id);
//		ResponseEntity<Login> bb=new ResponseEntity<Login>(b1,HttpStatus.OK);
//		return bb;
//	}
//	@DeleteMapping("/deletebyid/{id}")
//	public String deleteLoginById(@PathVariable int id) throws Throwable
//	{
//		loginservice.deleteLoginById(id);
//		return "Deleted Sucdessfully";
//	}
//	@DeleteMapping("deleteLogin")
//	public String deleteLogin(@RequestBody Login b)
//	{
//		loginservice.deleteLogin(b);
//		return "Deleted Sucdessfully";
//	}
//	
}
