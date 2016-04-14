package com.hibernate.doc.configuration.test;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.junit.Test;

import com.hibernate.doc.configuration.HibernateUtil;

public class HibernateConfigurationTest {

	@Test
	public void shouldCheckIfHibernateConfigurationIsWorkingProperly() throws Exception {
		Session session = new HibernateUtil().getSession();
		
		boolean sessionIsConnected = session.isConnected();
		
		assertTrue(sessionIsConnected);
		
		session.close();
	}
	
}
