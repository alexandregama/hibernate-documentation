package com.hibernate.doc.contact;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
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
	
	//When we use two or more times the same embeddable types hibernate requires us to use override attributes using @AttributeOverride
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "line1", column = @Column(name = "work_address_line_1")),
			@AttributeOverride(name = "line2", column = @Column(name = "work_address_line_2")),
			@AttributeOverride(name = "zipcode.code", column = @Column(name = "work_zipcode_code")),
			@AttributeOverride(name = "zipcode.plus", column = @Column(name = "work_zipcode_plus"))
	})
	private Address workAddress;
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "line1", column = @Column(name = "house_address_line_1")),
			@AttributeOverride(name = "line2", column = @Column(name = "house_address_line_2")),
			@AttributeOverride(name = "zipcode.code", column = @Column(name = "house_zipcode_code")),
			@AttributeOverride(name = "zipcode.plus", column = @Column(name = "house_zipcode_plus"))
	})
	private Address houseAddress;
	
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

	public Address getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(Address houseAddress) {
		this.houseAddress = houseAddress;
	}


}
