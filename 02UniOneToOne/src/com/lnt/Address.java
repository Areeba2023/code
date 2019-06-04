package com.lnt;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address1234")
public class Address {
	@Id
	private int addressId;
	private String city;
	private String country;
	
	
	
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public int getAddressId() {
		return addressId;
	}
	
	public Address() {
		// TODO Auto-generated constructor stub
	}


	public Address(int addressId, String city, String country) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city
				+ ", country=" + country + "]";
	}

	
	
}
