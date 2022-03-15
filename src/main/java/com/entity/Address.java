package com.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="OrderPlaced")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	
	private int cid;
	
	@NotNull
	@Size(max=30)
	private String cname;
	
	
	private int rid;
	
	@NotNull
	private int total_bill;


	@NotNull
	private String paymentMode;
	
	@NotNull
	@Size(max=50)
	private String address;
	
	@NotNull
	@Size(min=10,max=10)
    @Pattern(regexp="^[0-9]+$")
	private String phone;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="order_fk", referencedColumnName = "oid")
	private List<OrderFoodItem> orderFoodItems;
	
	

	public int getOid() {
		return oid;
	}



	public void setOid(int oid) {
		this.oid = oid;
	}



	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
	}



	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
	}



	public int getRid() {
		return rid;
	}



	public void setRid(int rid) {
		this.rid = rid;
	}



	public int getTotal_bill() {
		return total_bill;
	}



	public void setTotal_bill(int total_bill) {
		this.total_bill = total_bill;
	}



	public String getPaymentMode() {
		return paymentMode;
	}



	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public List<OrderFoodItem> getOrderFoodItems() {
		return orderFoodItems;
	}



	public void setOrderFoodItems(List<OrderFoodItem> orderFoodItems) {
		this.orderFoodItems = orderFoodItems;
	}



	@Override
	public String toString() {
		return "Address [cid=" + cid + ", cname=" + cname + ", rid=" + rid + ", total_bill=" + total_bill + ", paymentMode=" + paymentMode + ", address=" + address
				+ ", phone=" + phone + "]";
	}

	
	
}