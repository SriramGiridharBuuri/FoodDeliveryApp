package com.service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.BillingAddressNotFoundException;
import com.entity.BillingAddress;
import com.repository.BiilingRepo;

@Service
public class BillAddService {
	@Autowired
	BiilingRepo billingRepo;
	public BillingAddress addBillAddress(BillingAddress b)
	{
		billingRepo.save(b);
		return b;
	}
	public String deleteBillAddress(BillingAddress b)
	{
		billingRepo.delete(b);
		return "Delete Successfully";
	}
	public BillingAddress updateAddress(BillingAddress b) throws Throwable 
	{
		Supplier s1 = ()-> new BillingAddressNotFoundException("Id does not Exists");
		int id = b.getCid();
		BillingAddress b1=billingRepo.findById(id).orElseThrow(s1);
		b1.setFlatno(b1.getFlatno());
		b1.setStreet(b1.getStreet());
		b1.setArea(b1.getArea());
		b1.setCity(b1.getCity());
		b1.setState(b1.getState());
		billingRepo.save(b1);
		return b1;
	}
	public BillingAddress getById(int cid) throws Throwable
	{
		Supplier s1= () -> new BillingAddressNotFoundException("Id not found /Incorrect Id");
		BillingAddress b=billingRepo.findById(cid).orElseThrow(s1);
		return b;
	}
	public String deleteBillAddressById(int cid) throws Throwable
	{
		Supplier s1= () -> new BillingAddressNotFoundException("Id not found /Incorrect Id");
		billingRepo.deleteById(cid);
		return "Delete Successfully";
	}
}
