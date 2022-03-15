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

import com.entity.Restaurant;
import com.repository.RestaurantRepo;

@SpringBootTest
class RestaurantServiceImplTest {
	
	@Autowired
	RestaurantService restaurantService;
	
	@MockBean
	RestaurantRepo restaurantRepo;
	
	@Test
	void testAddRestaurant() {
		Restaurant r = new Restaurant();
		r.setRid(1011);
		r.setRname("Sitara");
		r.setRphone("9988776655");
		r.setRemail("sitara@gmail.com");
		r.setTypeoffood("Veg/Non-Veg");
		r.setRaddress("Amaravati");
		
		Mockito.when(restaurantRepo.save(r)).thenReturn(r);
		 
		 assertThat(restaurantService.addRestaurant(r)).isEqualTo(r);
	}
	
	@Test
	void testUpdateRestauarant() throws Throwable {
		Restaurant r = new Restaurant();
		r.setRid(1011);
		r.setRname("Sitara");
		r.setRphone("9988776655");
		r.setRemail("sitara@gmail.com");
		r.setTypeoffood("Veg/Non-Veg");
		r.setRaddress("Amaravati");
		
		Optional<Restaurant> r1 = Optional.of(r);
		Mockito.when(restaurantRepo.findById(1011)).thenReturn(r1);
		Mockito.when(restaurantRepo.save(r)).thenReturn(r);
		r.setRname("paradise");
		r.setRaddress("Hyderabad");
		
		assertThat(restaurantService.updateRestaurant(r)).isEqualTo(r);
	}
	
	@Test
	void testGetById() throws Throwable {
		Restaurant r = new Restaurant();
		r.setRid(1011);
		r.setRname("Sitara");
		r.setRphone("9988776655");
		r.setRemail("sitara@gmail.com");
		r.setTypeoffood("Veg/Non-Veg");
		r.setRaddress("Amaravati");
		
		Optional<Restaurant> r1 = Optional.of(r);
		
		Mockito.when(restaurantRepo.findById(1011)).thenReturn(r1);
		assertThat(restaurantService.getById(1011)).isEqualTo(r);
	}
	
	@Test
	void testGetNearestRestaurant() throws Throwable {
		Restaurant r = new Restaurant();
		r.setRid(1011);
		r.setRname("Sitara");
		r.setRphone("9988776655");
		r.setRemail("sitara@gmail.com");
		r.setTypeoffood("Veg/Non-Veg");
		r.setRaddress("Amaravati");
		
		Restaurant r1 = new Restaurant();
		r1.setRid(1011);
		r1.setRname("Sitara");
		r1.setRphone("9988776655");
		r1.setRemail("sitara@gmail.com");
		r1.setTypeoffood("Veg/Non-Veg");
		r1.setRaddress("Amaravati");
		
		List<Restaurant> restaurantList = new ArrayList<>();
		restaurantList.add(r);
		restaurantList.add(r1);
		
		Mockito.when(restaurantRepo.findByRaddress("Amaravati")).thenReturn(restaurantList);
		assertThat(restaurantService.getNearestRestaurant("Amaravati")).isEqualTo(restaurantList);
	}
	
	@Test
	void testDeleteRestaurantById() {
		Restaurant r = new Restaurant();
		r.setRid(1011);
		r.setRname("Sitara");
		r.setRphone("9988776655");
		r.setRemail("sitara@gmail.com");
		r.setTypeoffood("Veg/Non-Veg");
		r.setRaddress("Amaravati");
		
		Optional<Restaurant> r1 = Optional.of(r);
		
		Mockito.when(restaurantRepo.findById(1011)).thenReturn(r1);
		assertThat(restaurantService.deleteRestaurantById(1011)).isEqualTo("Row Deleted Successfully");
	}
	
	@Test
	void testDeleteRestaurant() {
		Restaurant r = new Restaurant();
		r.setRid(1011);
		r.setRname("Sitara");
		r.setRphone("9988776655");
		r.setRemail("sitara@gmail.com");
		r.setTypeoffood("Veg/Non-Veg");
		r.setRaddress("Amaravati");
		
		Optional<Restaurant> r1 = Optional.of(r);
		Mockito.when(restaurantRepo.findById(1011)).thenReturn(r1);
		Mockito.when(restaurantRepo.existsById(r.getRid())).thenReturn(false);
		assertThat(restaurantRepo.existsById(r.getRid()));
	}
	

}
