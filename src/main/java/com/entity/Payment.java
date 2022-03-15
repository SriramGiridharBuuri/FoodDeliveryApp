package com.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(name="Payment_id")
      private int paymentid;
      @Column(name="cardnumber")
      private int cardnumber;
      @Column(name="cvv")
      private int cvv;
      @Column(name="customerId")
      private String customerId;
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public int getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(int cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", cardnumber=" + cardnumber + ", cvv=" + cvv + "]";
	}
      
	
}