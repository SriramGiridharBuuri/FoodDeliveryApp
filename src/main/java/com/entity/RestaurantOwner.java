package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class RestaurantOwner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
//	@NotNull
//	@Size(max=50)
//	private String rname;
	@Size(max=30)
	private String ownername;
	@NotNull
	@Size(min=10,max=10)
	@Pattern(regexp="^\\d{10}$")
	private String phone;
	@Pattern(regexp="^[a-zA-Z0-9_/-/.]+[@][a-z]+[/.][a-z]{2,3}")
	private String email;
	@Size(min=4, max=16)
	private String password;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="ro_fk", referencedColumnName = "email")
//	private List<Restaurant> restaurants;

//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "rid", referencedColumnName = "rid")
//	private Restaurant restaurant;

//	public int getRid() {
//		return rid;
//	}
//
//	public void setRid(int rid) {
//		this.rid = rid;
//	}
//
//	public String getRname() {
//		return rname;
//	}
//
//	public void setRname(String rname) {
//		this.rname = rname;
//	}

	public String getOwnername() {
		return ownername;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

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
		return "RestaurantOwner [id=" + id + ", ownername=" + ownername + ", phone=" + phone
				+ ", email=" + email + ", password=" + password + "]";
	}

}
