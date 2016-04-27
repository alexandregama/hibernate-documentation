package com.hibernate.doc.contact;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Embedded
	private Name name;
	
	@Embedded
	private Address workAddress;
	
	@Deprecated //Required for Hibernate
	Contact() {
	}
	
	public Contact(Name name) {
		this.name = name;
	}
	
	public Contact(Name name, Address workAddress) {
		this.name = name;
		this.workAddress = workAddress;
	}

	public Long getId() {
		return id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}


}
