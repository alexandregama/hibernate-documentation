package com.hibernate.doc.contact;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "line_1")
	private String line1;

	@Column(name = "line_2")
	private String line2;

	@Deprecated //Required for Hibernate
	Address() {
	}
	
	public Address(String line1, String line2) {
		this.line1 = line1;
		this.line2 = line2;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

}
