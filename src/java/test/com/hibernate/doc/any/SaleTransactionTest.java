package com.hibernate.doc.any;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.doc.configuration.HibernateUtil;

public class SaleTransactionTest {

	private Session session;

	@Before
	public void setup() {
		session = new HibernateUtil().getSession();
		session.getTransaction().begin();
		
		removeAllSaleTransactions();
	}

	private void removeAllSaleTransactions() {
		Query query = session.createQuery("delete from SaleTransaction");
		query.executeUpdate();
	}
	
	@After
	public void setdown() {
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void shouldSaveANewSaleTransactionForBus() throws Exception {
		Bus bus = new Bus(120L, "1234", 200L, 30, true);
		SaleTransaction transaction = new SaleTransaction(new Date(), 100L, bus);
		
		HibernateSaleTransactionsDao transactions = new HibernateSaleTransactionsDao(session);
		transactions.save(transaction);
		
		SaleTransaction saleTransactionFound = transactions.findBy(transaction.getId());

		assertTrue(saleTransactionFound.getVehicle().getClass().isAssignableFrom(Bus.class));
	}
	
	@Test
	public void shouldSaveANewSaleTransactionForTruck() throws Exception {
		Truck truck = new Truck(120L, "1234", 200L, 150L);
		SaleTransaction transaction = new SaleTransaction(new Date(), 100L, truck);
		
		HibernateSaleTransactionsDao transactions = new HibernateSaleTransactionsDao(session);
		transactions.save(transaction);
		
		SaleTransaction saleTransactionFound = transactions.findBy(transaction.getId());
		
		assertTrue(saleTransactionFound.getVehicle().getClass().isAssignableFrom(Truck.class));
	}
	
}
