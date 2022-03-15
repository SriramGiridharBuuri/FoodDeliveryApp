package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.OrderDetails;
import com.repository.OrderDetailsRepo;

@Service
public class OrderDetailsService {
	
	@Autowired
	private OrderDetailsRepo orderDetailsRepo;
	
	public OrderDetails addOrderDetails(OrderDetails od) {
		orderDetailsRepo.save(od);
		return od;
	}
	
	public String deleteOrderDetails() {
		orderDetailsRepo.deleteAll();
		return "Oder History Deleted Successfully";
	}
}
