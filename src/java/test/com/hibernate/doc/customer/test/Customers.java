package com.hibernate.doc.customer.test;

import com.hibernate.doc.customer.Customer;

public interface Customers {

	void save(Customer customer);

	Customer findBy(Long id);
	
}
