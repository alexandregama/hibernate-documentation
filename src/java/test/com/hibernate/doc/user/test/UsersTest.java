package com.hibernate.doc.user.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.doc.configuration.HibernateUtil;
import com.hibernate.doc.user.HibernateUsersDao;
import com.hibernate.doc.user.User;
import com.hibernate.doc.user.Users;

public class UsersTest {

	private Session session;

	@Before
	public void setup() {
		session = new HibernateUtil().getSession();
		session.getTransaction().begin();
		
		removeAllUsers();
	}

	private void removeAllUsers() {
		Query query = session.createQuery("delete from User");
		query.executeUpdate();
	}
	
	@After
	public void setdown() {
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void shouldSaveANewUser() throws Exception {
		User user = User.builder().withCreditCardNumber("ABCD").build();
		
		Users users = new HibernateUsersDao(session);
		users.save(user);
		
		Optional<User> userFound = users.findBy(user.getId());
		
		assertTrue(userFound.isPresent());
	}
	
	@Test
	public void shouldSaveANewUserEncryptingItsCreditCardNumberUsingAnExistentMysqlFunction() throws Exception {
		User user = User.builder().withCreditCardNumber("ABCDE").build();
		
		Users users = new HibernateUsersDao(session);
		users.save(user);
		
		Optional<User> userFound = users.findBy(user.getId());
		
		assertTrue(userFound.isPresent());
		assertEquals("ABCDE", userFound.get().getCreditCardNumber());
	}
	
}
