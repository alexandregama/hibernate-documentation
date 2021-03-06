package com.hibernate.doc.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public Session getSession() {
		Configuration cfg = new Configuration()
				.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect")
			    .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost:3306/hibernate-documentation")
			    .setProperty(AvailableSettings.USER, "root")
			    .setProperty(AvailableSettings.PASS, "")
			    .setProperty(AvailableSettings.HBM2DDL_AUTO, "update")
			    .setProperty(AvailableSettings.SHOW_SQL, "true")
			    .setProperty(AvailableSettings.FORMAT_SQL, "true")
			    .addAnnotatedClass(com.hibernate.doc.customer.Customer.class)
			    .addAnnotatedClass(com.hibernate.doc.shipping.Shipping.class)
				.addAnnotatedClass(com.hibernate.doc.user.User.class)
				.addAnnotatedClass(com.hibernate.doc.any.Bus.class)
				.addAnnotatedClass(com.hibernate.doc.any.Truck.class)
				.addAnnotatedClass(com.hibernate.doc.any.SaleTransaction.class)
				.addAnnotatedClass(com.hibernate.doc.contact.Contact.class);

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		return sessionFactory.openSession();
	}

}
