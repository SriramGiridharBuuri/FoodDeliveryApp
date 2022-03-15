package com.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.BillingAddress;
import com.repository.BiilingRepo;

@SpringBootTest
public class BillAddressServiceImpl {
	@Autowired
	BillAddService billAddService;
	
	@MockBean
	BiilingRepo billingRepo;
	
	@Test
	void testAddBillingAddress()
	{
		BillingAddress b= new BillingAddress();
		b.setCid(3939);
		b.setcName("Anuja");
		b.setFlatno("10-20");
		b.setStreet("Ramalayam");
		b.setArea("Guntur");
		b.setCity("Guntur");
		b.setState("AndraPradesh");
		
		Mockito.when(billingRepo.save(b)).thenReturn(b);
		assertThat(billAddService.addBillAddress(b)).isEqualTo(b);
	}
	
	@Test
	void testUpdateAddress() throws Throwable
	{
		BillingAddress b= new BillingAddress();
		b.setCid(3939);
		b.setcName("Anuja");
		b.setFlatno("10-20");
		b.setStreet("Ramalayam");
		b.setArea("Guntur");
		b.setCity("Guntur");
		b.setState("AndraPradesh");
		Optional<BillingAddress> b1 = Optional.of(b);
		Mockito.when(billingRepo.findById(3939)).thenReturn(b1);
		
		Mockito.when(billingRepo.save(b)).thenReturn(b);
		b.setcName("Sri");
		b.setFlatno("20-20");
		b.setStreet("Agraharam");
		b.setArea("Guntur");
		
		assertThat(billAddService.updateAddress(b)).isEqualTo(b);
	}
	@Test
	void testGetById() throws Throwable
	{
		BillingAddress b= new BillingAddress();
		b.setCid(3939);
		b.setcName("Anuja");
		b.setFlatno("10-20");
		b.setStreet("Ramalayam");
		b.setArea("Guntur");
		b.setCity("Guntur");
		b.setState("AndraPradesh");
		Optional<BillingAddress> b1=Optional.of(b);
		Mockito.when(billingRepo.findById(3939)).thenReturn(b1);
		assertThat(billAddService.getById(3939)).isEqualTo(b);
	}
	@Test
	void testDeleteBillAddress()
	{
		BillingAddress b= new BillingAddress();
		b.setCid(3939);
		b.setcName("Anuja");
		b.setFlatno("10-20");
		b.setStreet("Ramalayam");
		b.setArea("Guntur");
		b.setCity("Guntur");
		b.setState("AndraPradesh");
		Optional<BillingAddress> b1=Optional.of(b);
		Mockito.when(billingRepo.findById(3939)).thenReturn(b1);
		Mockito.when(billingRepo.existsById(b.getCid())).thenReturn(false);
		assertThat(billingRepo.existsById(b.getCid()));
	}
	@Test
	void testDeleteBillAddressById() throws Throwable
	{
		BillingAddress b= new BillingAddress();
		b.setCid(3939);
		b.setcName("Anuja");
		b.setFlatno("10-20");
		b.setStreet("Ramalayam");
		b.setArea("Guntur");
		b.setCity("Guntur");
		b.setState("AndraPradesh");
		Optional<BillingAddress> b1=Optional.of(b);
		Mockito.when(billingRepo.findById(3939)).thenReturn(b1);
		assertThat(billAddService.deleteBillAddressById(3939)).isEqualTo("Delete Successfully");
	}
}
