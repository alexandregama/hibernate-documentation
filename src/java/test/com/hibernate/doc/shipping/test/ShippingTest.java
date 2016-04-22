package com.hibernate.doc.shipping.test;

import static org.junit.Assert.*;

import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.doc.configuration.HibernateUtil;
import com.hibernate.doc.shipping.HibernateShippingsDao;
import com.hibernate.doc.shipping.Shipping;
import com.hibernate.doc.shipping.Shippings;

public class ShippingTest {

	private Session session;

	@Before
	public void setup() {
		session = new HibernateUtil().getSession();
		session.getTransaction().begin();
		
		deleteAllShippings();
	}

	@After
	public void setdown() {
		session.getTransaction().commit();
		session.close();
	}
	
	private void deleteAllShippings() {
		Query query = session.createQuery("delete from Shipping");
		query.executeUpdate();
	}
	
	@Test
	public void shouldSaveANewShipping() throws Exception {
		Shippings shippings = new HibernateShippingsDao(session);
		
		Shipping shipping = new Shipping(2L, 10L, 5L);
		shippings.save(shipping);
		
		Optional<Shipping> shippingFound = shippings.findBy(shipping.getId());
		
		assertTrue(shippingFound.isPresent());
	}
	
}
