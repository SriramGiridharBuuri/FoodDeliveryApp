package com.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	private String cname;
	private String rname;
	private String rbranch;
	private Date timeanddate;
	private String fooditem;
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
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRbranch() {
		return rbranch;
	}
	public void setRbranch(String rbranch) {
		this.rbranch = rbranch;
	}
	public Date getTimeanddate() {
		return timeanddate;
	}
	public void setTimeanddate(Date timeanddate) {
		this.timeanddate = timeanddate;
	}
	public String getFooditem() {
		return fooditem;
	}
	public void setFooditem(String fooditem) {
		this.fooditem = fooditem;
	}
	@Override
	public String toString() {
		return "OrderDetails [cid=" + cid + ", cname=" + cname + ", rname=" + rname + ", rbranch=" + rbranch
				+ ", timeanddate=" + timeanddate + ", fooditem=" + fooditem + "]";
	}
	
	
}
