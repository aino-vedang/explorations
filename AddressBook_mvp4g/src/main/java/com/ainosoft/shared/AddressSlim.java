package com.ainosoft.shared;

import java.io.Serializable;

public class AddressSlim implements Serializable{

	private String name, street, city, country, zip;
	
	private Long id;

	public AddressSlim(String name, String street, String city, String country,
			String zip) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}
	
	
	
	public AddressSlim(Long id,String name, String street, String city, String country,
			String zip) {
		this.id = id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}
	
	public AddressSlim(Long id,String name) {
		this.id = id;
		this.name = name;
		
	}
	
	public AddressSlim() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
