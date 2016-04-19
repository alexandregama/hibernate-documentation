package com.hibernate.doc.customer;

import javax.persistence.AttributeConverter;

import com.hibernate.doc.customer.Customer.Gender;

public class GenderEnumToStringConverter implements AttributeConverter<Gender, String> {

	@Override
	public String convertToDatabaseColumn(Gender attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getCode();
	}

	@Override
	public Gender convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}
		return Gender.getFromCode(code);
	}

}
