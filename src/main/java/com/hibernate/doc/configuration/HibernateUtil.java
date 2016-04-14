package com.hibernate.doc.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public Session getSession() {
		Configuration cfg = new Configuration()
				.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect")
//				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect")
			    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate-documentation")
			    .setProperty("hibernate.connection.username", "root")
			    .setProperty("hibernate.connection.password", "")
			    .setProperty("hibernate.hbm2ddl", "auto")
			    .setProperty("show_sql", "true")
			    .setProperty("format_sql", "true");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		return sessionFactory.openSession();
	}

}
