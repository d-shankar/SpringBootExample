package com.example.mobilecharge.charge.MobileModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name= "charge_table")
public class Mobile {
	@Id
	@NotNull
	@Column(name="brandid")
	int chargeId;

	@NotNull
	@Column(name= "brand")
	String brand;

	@NotNull
	@Column(name= "description")
	String description;
	
	public Mobile() {
		super();
	}

	public Mobile(int chargeId, String brand, String description) {
		super();
		this.chargeId = chargeId;
		this.brand = brand;
		this.description=description;
	}

	public int getChargeId() {
		return chargeId;
	}

	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	
}
