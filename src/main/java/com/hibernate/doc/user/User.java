package com.hibernate.doc.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

@Table(name = "Users")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "credit_card_number", length = 20)
	@ColumnTransformer(write = "encrypt_value(?)", read = "decrypt_value(credit_card_number)")
	private String creditCardNumber;

	public Long getId() {
		return id;
	}

	public static UserBuilder builder() {
		return new UserBuilder();
	}
	
	public static class UserBuilder {
		private User user;
		
		public UserBuilder() {
			this.user = new User();
		}
		
		public UserBuilder withCreditCardNumber(String number) {
			this.user.setCreditCardNumber(number);
			return this;
		}
		
		public User build() {
			return this.user;
		}
	}
	
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	
}
