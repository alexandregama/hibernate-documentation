package com.hibernate.doc.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public Session getSession() {
		Configuration cfg = new Configuration()
				.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect")
			    .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost:3306/hibernate-documentation")
			    .setProperty(AvailableSettings.USER, "root")
			    .setProperty(AvailableSettings.PASS, "")
			    .setProperty("hibernate.hbm2ddl", "true")
			    .setProperty(AvailableSettings.SHOW_SQL, "true")
			    .setProperty(AvailableSettings.FORMAT_SQL, "true");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		return sessionFactory.openSession();
	}

}
