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

import com.entity.Login;
import com.service.LoginService;

@SpringBootTest
class LoginServiceTest {
	
@Autowired
LoginService loginservice;

//@MockBean
//LoginRepository loginrepository;

@Test
void testAddLogin()
{
	Login b= new Login();
	b.setEmail("Anuja123@gmail.com");
	b.setPassword("1020");

	
	
	assertThat(loginservice.addLogin(b)).isEqualTo("Login failed");
}

//@Test
//void testUpdateAddress() throws Throwable
//{
//	Login b= new Login();
//	b.setid(3939);
//	b.setEmail("Anuja123@gmail.com");
//	b.setPassword("1020");
//	Optional<Login> b1 = Optional.of(b);
//	Mockito.when(loginrepository.findById(3939)).thenReturn(b1);
//	
//	Mockito.when(loginrepository.save(b)).thenReturn(b);
//	b.setEmail("Sri123@gmail.com");
//	b.setPassword("2020");
//	
//	assertThat(loginservice.updateLogin(b)).isEqualTo(b);
//}
//@Test
//void testGetById() throws Throwable
//{
//	Login b= new Login();
//	b.setid(3939);
//	b.setEmail("Anuja123@gmail.com");
//	b.setPassword("1020");
//	Optional<Login> b1=Optional.of(b);
//	Mockito.when(loginrepository.findById(3939)).thenReturn(b1);
//	assertThat(loginservice.getById(3939)).isEqualTo(b);
//}
//@Test
//void testDeleteLogin()
//{
//	Login b= new Login();
//	b.setid(3939);
//	b.setEmail("Anuja123@gmail.com");
//	b.setPassword("1020");
//	Optional<Login> b1=Optional.of(b);
//	Mockito.when(loginrepository.findById(3939)).thenReturn(b1);
//	Mockito.when(loginrepository.existsById(b.getId())).thenReturn(false);
//	assertThat(loginrepository.existsById(b.getId()));
//}
//@Test
//void testDeleteBillAddressById() throws Throwable
//{
//	Login b= new Login();
//	b.setid(3939);
//	b.setEmail("Anuja123@gmail.com");
//	b.setPassword("1020");
//	Optional<Login> b1=Optional.of(b);
//	Mockito.when(loginrepository.findById(3939)).thenReturn(b1);
//	assertThat(loginservice.deleteLoginById(3939)).isEqualTo("Delete Successfully");
//}

}

