package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Customer;
import com.repository.CustomerRepo;

@SpringBootTest
class CustomerServiceImplTest {

	@Autowired
	CustomerService customerService;
	
	@MockBean
	CustomerRepo customerrepo;

	@Test
	void testAddCustomer() {
		Customer c1 = new Customer();
		c1.setCid(1222);
		c1.setCname("Tara");
		c1.setCphone("98675434578");
		c1.setCemail("tara@gmail.com");
		c1.setCaddress("BlockC");
		c1.setCcity("Delhi");
		
		Mockito.when(customerrepo.save(c1)).thenReturn(c1);
		assertThat(customerService.addCustomer(c1)).isEqualTo(c1);
		
	}

	@Test
	void testGetCustomers() {
		Customer c1 = new Customer();
		c1.setCid(1222);
		c1.setCname("Tara");
		c1.setCphone("98675434578");
		c1.setCemail("tara@gmail.com");
		c1.setCaddress("BlockC");
		c1.setCcity("Delhi");
		
		Customer c2 = new Customer();
		c1.setCid(1223);
		c1.setCname("Rudra");
		c1.setCphone("99175434578");
		c1.setCemail("rudra@gmail.com");
		c1.setCaddress("BlockK");
		c1.setCcity("Telangana");
		
		Customer c3 = new Customer();
		c1.setCid(1224);
		c1.setCname("radha");
		c1.setCphone("34578963536");
		c1.setCemail("radha@gmail.com");
		c1.setCaddress("Street 4");
		c1.setCcity("Srinagar");
		
		List<Customer> customerList = new ArrayList<>();
		customerList.add(c1);
		customerList.add(c2);
		customerList.add(c3);
		
		Mockito.when(customerrepo.findAll()).thenReturn(customerList);
		assertThat(customerService.getCustomers()).isEqualTo(customerList);
	}

	@Test
	void testGetCustomerById() throws Throwable {
		Customer c1 = new Customer();
		c1.setCid(1222);
		c1.setCname("Tara");
		c1.setCphone("98675434578");
		c1.setCemail("tara@gmail.com");
		c1.setCaddress("BlockC");
		c1.setCcity("Delhi");
		
		Optional<Customer> c2 = Optional.of(c1);
		Mockito.when(customerrepo.findById(1222)).thenReturn(c2);
		
		assertThat(customerService.getCustomerById(1222)).isEqualTo(c1);
		
	}

	@Test
	void testUpdateCustomer() throws Throwable {
		Customer c1 = new Customer();
		c1.setCid(1222);
		c1.setCname("Tara");
		c1.setCphone("98675434578");
		c1.setCemail("tara@gmail.com");
		c1.setCaddress("BlockC");
		c1.setCcity("Delhi");
		
		Optional<Customer> c2=Optional.of(c1);		
        Mockito.when(customerrepo.findById(1222)).thenReturn(c2);
        
        Mockito.when(customerrepo.save(c1)).thenReturn(c1);
		c1.setCname("Shreya");
		c1.setCaddress("BlockJ");
		
		assertThat(customerService.updateCustomer(c1)).isEqualTo(c1);
	}

	@Test
	void testDeleteCustomerById() {
		Customer c1 = new Customer();
		c1.setCid(1222);
		c1.setCname("Tara");
		c1.setCphone("98675434578");
		c1.setCemail("tara@gmail.com");
		c1.setCaddress("BlockC");
		c1.setCcity("Delhi");
		
		Optional<Customer> c2=Optional.of(c1);
		
		Mockito.when(customerrepo.findById(1222)).thenReturn(c2);
		Mockito.when(customerrepo.existsById(c1.getCid())).thenReturn(false);
		assertFalse(customerrepo.existsById(c1.getCid()));
	}
}
