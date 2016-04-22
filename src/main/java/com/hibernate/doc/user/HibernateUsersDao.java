package com.hibernate.doc.user;

import java.util.Optional;

import org.hibernate.Session;

public class HibernateUsersDao implements Users {

	private Session session;
	
	public HibernateUsersDao(Session session) {
		this.session = session;
	}
	
	@Override
	public void save(User user) {
		session.save(user);
	}

	@Override
	public Optional<User> findBy(Long id) {
		return Optional.ofNullable(session.get(User.class, id));
	}

}
