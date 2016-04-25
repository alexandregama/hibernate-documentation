package com.hibernate.doc.shipping;

import java.util.Optional;

import org.hibernate.Session;

public class HibernateShippingsDao implements Shippings {

	private Session session;
	
	public HibernateShippingsDao(Session session) {
		this.session = session;
	}
	
	@Override
	public void save(Shipping shipping) {
		session.save(shipping);
	}

	@Override
	public Optional<Shipping> findBy(Long id) {
		return Optional.ofNullable(session.get(Shipping.class, id));
	}

}
