package com.hibernate.doc.customer.test;

import static org.junit.Assert.assertEquals;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.doc.configuration.HibernateUtil;
import com.hibernate.doc.customer.Customer;

public class CustomerTest {

	private Session session;
	
	@Before
	public void setup() {
		session = new HibernateUtil().getSession();
		session.beginTransaction();
		
		Query query = session.createQuery("delete from Customer");
		query.executeUpdate();
	}
	
	@After
	public void setdown() {
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void shouldSaveANewCustomer() throws Exception {
		Customer customer = new Customer("Alexandre", "Gama");
		
		Customers customers = new HibernateCustomersDao(session);
		
		customers.save(customer);
		
		Customer customerSaved = customers.findBy(customer.getId());
		
		assertEquals("Alexandre", customerSaved.getFirstName());
		assertEquals("Gama", customerSaved.getLastName());
	}
	
}
