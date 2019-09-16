package com.upog.tennis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id 
	@Column(name = "ADDRESS_ID")
	int id;
	@Column(name = "STREET_ADDRESS_1")
	String streetAddress1;
	@Column(name = "STREET_ADDRESS_2")
	String streetAddress2;
	@Column(name = "CITY")
	String city;
	@Column(name = "STATE")
	String state;
	@Column(name = "COUNTRY")
	String country;
	@Column(name = "ZIP")
	int zip;
	
	

	public Address() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetAddress1() {
		return streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", streetAddress1=" + streetAddress1 + ", streetAddress2=" + streetAddress2
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", zip=" + zip + "]";
	}


}
