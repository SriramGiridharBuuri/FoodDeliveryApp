package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.RestaurantOwner;
import com.repository.RestaurantOwnerRepo;

@SpringBootTest
class RestaurantOwnerServiceImplTest {

	@Autowired
	RestaurantOwnerService restaurantOwnerService;
	
	@MockBean
	RestaurantOwnerRepo restaurantOwnerRepo;
	
	@Test
	void testAddOwner() {
		RestaurantOwner ro = new RestaurantOwner();
		ro.setId(1011);
		ro.setOwnername("Ravi");
		ro.setPhone("9988987865");
		ro.setEmail("sitara@Gmail.com");
		ro.setPassword("1234");
		
		Mockito.when(restaurantOwnerRepo.save(ro)).thenReturn(ro);
		 
		 assertThat(restaurantOwnerService.addOwner(ro)).isEqualTo(ro);
	}
	
	@Test
	void testGetOwner() throws Throwable {
		RestaurantOwner ro = new RestaurantOwner();
		ro.setId(1011);
		ro.setOwnername("Ravi");
		ro.setPhone("9988987865");
		ro.setEmail("sitara@Gmail.com");
		ro.setPassword("1234");
		
        Optional<RestaurantOwner> r1 = Optional.of(ro);
		
		Mockito.when(restaurantOwnerRepo.findById(1011)).thenReturn(r1);
		assertThat(restaurantOwnerService.getOwner(1011)).isEqualTo(ro);
		
	}
	
	@Test
	void testGetOwners() {
		RestaurantOwner ro = new RestaurantOwner();
		ro.setId(1011);
		ro.setOwnername("Ravi");
		ro.setPhone("9988987865");
		ro.setEmail("sitara@Gmail.com");
		ro.setPassword("1234");
		
		RestaurantOwner ro1 = new RestaurantOwner();
		ro1.setId(1012);
		ro1.setOwnername("Raju");
		ro1.setPhone("9988987865");
		ro1.setEmail("sitara@Gmail.com");
		ro1.setPassword("1234");
		
		List<RestaurantOwner> lr = new ArrayList<>();
		lr.add(ro);
		lr.add(ro1);
		
		Mockito.when(restaurantOwnerRepo.findAll()).thenReturn(lr);
		 
		 assertThat(restaurantOwnerService.getOwners()).isEqualTo(lr);
		
	}
	
	@Test
	void testUpdateOwner() throws Throwable {
		RestaurantOwner ro = new RestaurantOwner();
		ro.setId(1011);
		ro.setOwnername("Ravi");
		ro.setPhone("9988987865");
		ro.setEmail("sitara@Gmail.com");
		ro.setPassword("1234");
		
		Optional<RestaurantOwner> r1 = Optional.of(ro);
		Mockito.when(restaurantOwnerRepo.findById(1011)).thenReturn(r1);
		Mockito.when(restaurantOwnerRepo.save(ro)).thenReturn(ro);
		ro.setOwnername("Ram");
		ro.setPhone("8877996655");
		
		assertThat(restaurantOwnerService.updateOwner(ro)).isEqualTo(ro);
		
	}
	
	@Test
	void testDeleteOwnerById() {
		RestaurantOwner ro = new RestaurantOwner();
		ro.setId(1011);
		ro.setOwnername("Ravi");
		ro.setPhone("9988987865");
		ro.setEmail("sitara@Gmail.com");
		ro.setPassword("1234");
		
		Optional<RestaurantOwner> r1 = Optional.of(ro);
		Mockito.when(restaurantOwnerRepo.findById(1011)).thenReturn(r1);
		Mockito.when(restaurantOwnerRepo.existsById(ro.getId())).thenReturn(false);
		assertThat(restaurantOwnerRepo.existsById(ro.getId()));
		
	}

}
