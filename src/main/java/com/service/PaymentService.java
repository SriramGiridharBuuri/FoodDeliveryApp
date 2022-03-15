package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Payment;
import com.advices.PaymentNotFoundException;
import com.repository.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
	PaymentRepo Paymentrepo;

	public Payment MakePayment(Payment pay) {
		Paymentrepo.save(pay);
		return pay;
	}

	public List<Payment> getAll() {
		List<Payment> pc1 = Paymentrepo.findAll();
		return pc1;
	}

	public Payment getPaymentById(int paymentid) throws Throwable {

		Supplier s1 = () -> new PaymentNotFoundException("payment Does not exist in the database");
		Payment p = Paymentrepo.findById(paymentid).orElseThrow();
		return p;
	}


	public String deletePaymentById(int paymentid) {
			
			Paymentrepo.deleteById(paymentid);
			return "Deleted" ;
		
	}

	

}
