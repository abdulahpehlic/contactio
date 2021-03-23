package com.vaudience.contactio.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Contact")
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "contactId")
	private Long contactId;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "date")
	private Date birthDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
	private Address address;
	
	public Contact(String name, Date birthDate) {
		this.fullName = name;
		this.birthDate = birthDate;
	}
	
	public Long getContactId() {
		return contactId;
	}
	public String getName() {
		return fullName;
	}
	public void setName(String name) {
		this.fullName = name;
	}
	public Date getBrithDate() {
		return birthDate;
	}
	public void setBrithDate(Date brithDate) {
		this.birthDate = brithDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}