package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class BillingAddress 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bid;
	
	private int cid;
	@NotNull
	@Size(max=30)
	private String cName;
	private String flatno;
	@NotNull
	@Size(max=20)
	private String street;
	@NotNull
	@Size(max=20)
	private String area;
	@NotNull
	@Size(max=20)
	private String city;
	@NotNull
	@Size(max=20)
	private String state;
	
	//@OneToOne(mappedBy = "address")
	//private Adress adress;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	public String getFlatno() {
		return flatno;
	}
	public void setFlatno(String flatno) {
		this.flatno = flatno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "BillingAddress [cid=" + cid + ", cName=" + cName + ", flatno=" + flatno + ", street=" + street
				+ ", area=" + area + ", city=" + city + ", state=" + state + "]";
	}
}
