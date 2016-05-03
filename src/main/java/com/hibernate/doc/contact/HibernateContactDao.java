package com.hibernate.doc.contact;

import java.util.Optional;

import org.hibernate.Session;

public class HibernateContactDao implements Contacts {

	private Session session;

	public HibernateContactDao(Session session) {
		this.session = session;
	}

	@Override
	public void save(Contact contact) {
		session.save(contact);	
	}

	@Override
	public Optional<Contact> findContactByIts(Long id) {
		return Optional.ofNullable(session.get(Contact.class, id));
	}

}
