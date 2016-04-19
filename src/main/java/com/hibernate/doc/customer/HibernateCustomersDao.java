package com.hibernate.doc.customer;

import java.util.List;

import org.hibernate.Session;

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

	@Override
	public List<Customer> list() {
		// We must suppress the warning, once that Hibernate does not support Generic Type in its return method
		@SuppressWarnings("unchecked") 
		List<Customer> list = session.createCriteria(Customer.class).list();
		return list;
	}

}
