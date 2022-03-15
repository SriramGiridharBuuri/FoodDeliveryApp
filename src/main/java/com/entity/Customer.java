package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	@NotNull
	@Size(max=30)
	private String cname;
	@NotNull
	@Size(min=10,max=10)
	@Pattern(regexp="^\\d{10}$")
	private String cphone;
	@Pattern(regexp="^[a-zA-Z0-9_/-/.]+[@][a-z]+[/.][a-z]{2,3}")
	private String cemail;
	//@Pattern(regexp="^[a-zA-Z0-9]+$")
	private String caddress;
	@NotNull
	//@Pattern(regexp="^[a-zA-Z]+$")
	private String ccity;
	
	private String cpassword;
	
	
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
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
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCcity() {
		return ccity;
	}
	public void setCcity(String ccity) {
		this.ccity = ccity;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cphone=" + cphone + ", cemail=" + cemail + ", caddress="
				+ caddress + ", ccity=" + ccity + "]";
	}

}
