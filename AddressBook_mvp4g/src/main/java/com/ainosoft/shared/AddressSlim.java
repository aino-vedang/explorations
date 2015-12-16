package com.ainosoft.shared;

import java.io.Serializable;

import org.appops.altshared.shared.altcore.PojoMarker;
import org.appops.altshared.shared.altcore.annotations.Typename;

@Typename(typename = "Address")
public class AddressSlim implements Serializable, PojoMarker {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 5602527442727813356L;

	private String				name, street, city, country, zip;

	private Long				id;

	public AddressSlim() {

	}

	public AddressSlim(Long id, String name) {
		this.id = id;
		this.name = name;

	}

	public AddressSlim(Long id, String name, String street, String city, String country, String zip) {
		this.id = id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}

	public AddressSlim(String name, String street, String city, String country, String zip) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStreet() {
		return street;
	}

	public String getZip() {
		return zip;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		String addressString = "\nAddress : \n";
		if (this.getId() != null)
			addressString += "\tId 	: " + this.getId() + "\n";
		if (this.getName() != null)
			addressString += "\tName 	: " + this.getName() + "\n";
		if (this.getStreet() != null)
			addressString += "\tStreet 	: " + this.getStreet() + "\n";
		if (this.getCity() != null)
			addressString += "\tCity 	: " + this.getCity() + "\n";
		if (this.getCountry() != null)
			addressString += "\tCountry : " + this.getCountry() + "\n";
		if (this.getZip() != null)
			addressString += "\tZipcode : " + this.getZip() + "\n";

		return addressString;
	}
}
