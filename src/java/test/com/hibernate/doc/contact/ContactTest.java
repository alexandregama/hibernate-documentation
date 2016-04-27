package com.hibernate.doc.contact;

import static org.junit.Assert.*;

import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.doc.configuration.HibernateUtil;

public class ContactTest {

private Session session;
	
	@Before
	public void setup() {
		session = new HibernateUtil().getSession();
		session.beginTransaction();
		
		Query query = session.createQuery("delete from Contact");
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
	public void shouldSavaANewContactWithName() throws Exception {
		Contacts contacts = new HibernateContactDao(session);
		
		Name name = new Name("Alexandre", "Gama");
		Contact contact = new Contact(name);
		
		contacts.save(contact);
		
		Optional<Contact> contactFound = contacts.findContactByIts(contact.getId());
		
		assertTrue(contactFound.isPresent());
		assertEquals("Alexandre", contactFound.get().getName().getFirstName());
		assertEquals("Gama", contactFound.get().getName().getLastName());
	}
	
	@Test
	public void shouldSaveANewContactWithWorkAddres() throws Exception {
		Contacts contacts = new HibernateContactDao(session);
		
		Name name = new Name("Alexandre", "Gama");
		ZipCode withoutZipcode = null;
		Address address = new Address("First line 1", "Second line 2", withoutZipcode);
		Contact contact = new Contact(name, address);
		
		contacts.save(contact);
		
		Optional<Contact> contactFound = contacts.findContactByIts(contact.getId());
		
		assertTrue(contactFound.isPresent());
		assertEquals("First line 1", contactFound.get().getWorkAddress().getLine1());
		assertEquals("Second line 2", contactFound.get().getWorkAddress().getLine2());
	}
	
}
