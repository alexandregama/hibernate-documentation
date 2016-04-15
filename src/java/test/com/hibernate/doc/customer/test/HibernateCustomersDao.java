package com.hibernate.doc.customer.test;

import org.hibernate.Session;

import com.hibernate.doc.customer.Customer;

public class HibernateCustomersDao implements Customers {

	private Session session;

	public HibernateCustomersDao(Session session) {
		this.session = session;
	}
	
	@Override
	public void save(Customer customer) {
		session.save(customer);
	}

	@Override
	public Customer findBy(Long id) {
		return session.get(Customer.class, id);
	}

}
