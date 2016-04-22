package com.hibernate.doc.customer.test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.doc.configuration.HibernateUtil;
import com.hibernate.doc.customer.Customer;
import com.hibernate.doc.customer.Customers;
import com.hibernate.doc.customer.HibernateCustomersDao;

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
		if (session.isOpen()) {
			try {
				session.getTransaction().commit();
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void shouldSaveANewCustomer() throws Exception {
		Customer customer = Customer.builder().withFirstName("Alexandre").withLastName("Gama").build();
		
		Customers customers = new HibernateCustomersDao(session);
		
		customers.save(customer);
		
		Customer customerSaved = customers.findBy(customer.getId());
		
		assertEquals("Alexandre", customerSaved.getFirstName());
		assertEquals("Gama", customerSaved.getLastName());
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldNotBeAbleToSaveANewCustomerWithAUsernameThatHasBeenUsed() throws Exception {
		Customer alexandre = Customer.builder().withFirstName("Alexandre").withLastName("Gama").withUsername("alexandregama").build();
		Customer gama = Customer.builder().withFirstName("Ale").withLastName("Gama").withUsername("alexandregama").build();
		
		Customers customers = new HibernateCustomersDao(session);
		
		customers.save(alexandre);
		customers.save(gama);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void shouldNotBeAbleToSaveANewCustomerWithFirstAndLastnameThatHasBeenUsed() throws Exception {
		Customer alexandre = Customer.builder().withFirstName("Ale").withLastName("Gama").withUsername("gama").build();
		Customer gama = Customer.builder().withFirstName("Ale").withLastName("Gama").withUsername("ale").build();
		
		Customers customers = new HibernateCustomersDao(session);
		
		customers.save(alexandre);
		customers.save(gama);
	}
	
	@Test
	public void shouldRetrieveAListWithTwoCustomers() throws Exception {
		Customer alexandre = Customer.builder().withFirstName("Ale").withLastName("Gama").withUsername("gama").build();
		Customer gama = Customer.builder().withFirstName("Ale").withLastName("Gama").withUsername("ale").build();
		
		Customers customers = new HibernateCustomersDao(session);
		
		customers.save(alexandre);
		customers.save(gama);

		List<Customer> listOfCustomers = customers.list();
		
		assertEquals(listOfCustomers.size(), 2);
	}


	@Test
	public void shouldSaveANewCustomerWithCreatedAtDate() throws Exception {
		Calendar somePastDate = Calendar.getInstance();
		somePastDate.set(2016, 02, 12);
		Customer customer = Customer.builder().withFirstName("Alexandre").withLastName("Gama").createdAt(somePastDate).build();
		
		Customers customers = new HibernateCustomersDao(session);
		
		customers.save(customer);
		
		Customer customerSaved = customers.findBy(customer.getId());
		
		assertEquals("Alexandre", customerSaved.getFirstName());
		assertEquals("Gama", customerSaved.getLastName());
	}
}
