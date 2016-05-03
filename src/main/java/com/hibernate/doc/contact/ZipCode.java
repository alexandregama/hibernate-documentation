package com.hibernate.doc.contact;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ZipCode {

	@Column(name = "code")
	private String code;
	
	@Column(name = "plus")
	private String plus;

	@Deprecated //Required for Hibernate
	ZipCode() {
	}
	
	public ZipCode(String code, String plus) {
		this.code = code;
		this.plus = plus;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPlus() {
		return plus;
	}

	public void setPlus(String plus) {
		this.plus = plus;
	}
	
	
	
}
