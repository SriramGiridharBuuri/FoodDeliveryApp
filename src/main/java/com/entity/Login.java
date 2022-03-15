package com.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Login {
//      @Id
//	  @Column(name="Login_id")
//      @GeneratedValue(strategy=GenerationType.IDENTITY)
//      private int id;
      @NotEmpty
      @Email
      @Size(min=5,max=20,message="enter you email")
      private String email;
      @NotNull
      @Size(min=3,max=20,message="password should have atleast 4 characters")
      //@Column(name="password")
      private String password;
      
      private boolean isCustomer;
public boolean isCustomer() {
		return isCustomer;
	}
	public void setCustomer(boolean isCustomer) {
		this.isCustomer = isCustomer;
	}
	//	public int getId() {
//		return id;
//	}
//	public void setid(int id) {
//		this.id = id;
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [ email=" + email + ", password=" + password + "]";
	}
	
      
	
}

