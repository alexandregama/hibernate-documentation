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
	
	@Deprecated //Required for Hibernate
	Contact() {
	}
	
	public Contact(Name name) {
		this.name = name;
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


}
