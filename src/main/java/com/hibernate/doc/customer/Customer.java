package com.hibernate.doc.customer;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Type;

@Table(name = "customers", uniqueConstraints = {@UniqueConstraint(columnNames = {"first_name", "last_name"})})
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	@Basic // We do not need to use this is we are working with primitive types or its wrappers
	private String lastName;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "street_name", length = 30)
	private String streetName;
	
	@Column(name = "street_number", length = 30)
	private String streetNumber;
	
	@Type(type = "java.sql.Blob")
	@Column(name = "profile_description")
	private String profileDescription;
	
//	@Enumerated(EnumType.STRING) We can use EnumType.STRING or we are able to use a Convert from JPA 2.1
	@Convert(converter = GenderEnumToStringConverter.class) // We must be sure to not mark the attribute as Enumerated
	private Gender gender;
	
	// Hibernate automatically set property to insertable=false or updatable=false when we are using @Generated with GenerationTime
	@Generated(GenerationTime.INSERT)
	@Temporal(TemporalType.DATE)
	@Column(name = "created_at")
	private Calendar createdAt;
	
	public enum Gender {
		MALE("M"), FEMALE("F");
		
		private String code;
		
		Gender(String code) {
			this.code = code;
		}
		
		public static Gender getFromCode(String code) {
			if (code != null && code == "M") {
				return MALE;
			}
			if (code != null && code == "F") {
				return FEMALE;
			}
			return null;
		}
		
		public String getCode() {
			return code;
		}
	}

	private Customer() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public static CustomerBuilder builder() {
		return new CustomerBuilder();
	}
	
	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	public static class CustomerBuilder {
		
		private Customer customer;
		
		public CustomerBuilder() {
			this.customer = new Customer();
		}
		
		public CustomerBuilder withFirstName(String firstName) {
			this.customer.setFirstName(firstName);
			return this;
		}
		
		public CustomerBuilder withLastName(String lastName) {
			this.customer.setLastName(lastName);
			return this;
		}
		
		public CustomerBuilder withUsername(String username) {
			this.customer.setUsername(username);
			return this;
		}
		
		public CustomerBuilder inStreetNamed(String streetName) {
			this.customer.setStreetName(streetName);
			return this;
		}
		
		public CustomerBuilder inStreetNumber(String streetNumber) {
			this.customer.setStreetNumber(streetNumber);
			return this;
		}
		
		public CustomerBuilder createdAt(Calendar date) {
			this.customer.setCreatedAt(date);
			return this;
		}
		
		public Customer build() {
			return this.customer;
		}
	}
}
