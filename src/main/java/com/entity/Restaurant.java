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
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rid;
	@NotNull
	@Size(max=30)
	@Pattern(regexp = "^[A-Za-z 0-9]+$")
	private String rname;
	@NotNull
    @Size(max=50)
	private String raddress;
	@NotNull
	@Size(min=10,max=10)
	@Pattern(regexp="^\\d{10}$")
	private String rphone;
	@Pattern(regexp="^[a-zA-Z0-9_/-/.]+[@][a-z]+[/.][a-z]{2,3}")
	private String remail;
	@Size(min = 3, max = 15)
	@Pattern(regexp="^[A-Za-z-/]+$")
	private String typeoffood;
//	
//	@OneToOne(mappedBy = "restaurant")
//	private RestaurantOwner restaurantOwner;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="rest_fk", referencedColumnName = "rid")
	private List<FoodItem> foodItems;

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRaddress() {
		return raddress;
	}

	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}

	public String getRphone() {
		return rphone;
	}

	public void setRphone(String rphone) {
		this.rphone = rphone;
	}

	public String getRemail() {
		return remail;
	}

	public void setRemail(String remail) {
		this.remail = remail;
	}

	public String getTypeoffood() {
		return typeoffood;
	}

	public void setTypeoffood(String typeoffood) {
		this.typeoffood = typeoffood;
	}

	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", rname=" + rname + ", raddress=" + raddress + ", rphone=" + rphone
				+ ", remail=" + remail + ", typeoffood=" + typeoffood + ", foodItem=" + foodItems + "]";
	}
}
