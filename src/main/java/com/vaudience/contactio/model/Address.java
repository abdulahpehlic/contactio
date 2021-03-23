package com.vaudience.contactio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "addressId")
	private Long addressId;

	@Column(name = "city")
	private String city;
	
	@Column(name = "postalCode")
	private String postalCode;
	
	public Address(String city, String postalCode) {
		this.city = city;
		this.postalCode = postalCode;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
