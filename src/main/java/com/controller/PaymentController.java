package com.controller;

import java.util.List;

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
import com.entity.Payment;
import com.service.PaymentService;

@RestController
@RequestMapping("apipayment")
public class PaymentController {

	@Autowired
	PaymentService Paymentservice;

	// Create payment
	@PostMapping("/makepayment")
	public ResponseEntity<Payment> MakePayment(@RequestBody Payment pay) {
		Payment l = Paymentservice.MakePayment(pay);
		ResponseEntity<Payment> pp = new ResponseEntity<Payment>(l, HttpStatus.OK);
		return pp;
	}

	
	//Get All The paymentDetails
	@GetMapping(path="/getpayment")
	public ResponseEntity<List<Payment>> getAll() {
		List<Payment> pc1 = Paymentservice.getAll();
		ResponseEntity<List<Payment>> pp = new ResponseEntity<List<Payment>>(pc1, HttpStatus.OK);
		return pp;
	}
	// Get paymentDetails By ID
	@GetMapping(path = "/getpayment/{paymentid}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable int paymentid) throws Throwable {
		Payment p1 = Paymentservice.getPaymentById(paymentid);

		ResponseEntity<Payment> pp = new ResponseEntity<Payment>(p1, HttpStatus.OK);
		return pp;
	}

	//Delete The Record By paymentid
	
	@DeleteMapping(path="/deletepayment/{paymentid}")
	public ResponseEntity<String> deletePaymentById(@PathVariable int paymentid)
	{
		 Paymentservice.deletePaymentById(paymentid);
		
		ResponseEntity<String> pp=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return pp;
	}

}
