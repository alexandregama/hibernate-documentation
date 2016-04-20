package com.hibernate.doc.customer;

import java.util.List;

public interface Customers {

	void save(Customer customer);

	Customer findBy(Long id);

	List<Customer> list();
	
}
