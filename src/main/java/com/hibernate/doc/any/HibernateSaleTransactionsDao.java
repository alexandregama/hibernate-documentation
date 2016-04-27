package com.hibernate.doc.any;

import org.hibernate.Session;

public class HibernateSaleTransactionsDao implements SaleTransactions {

	private Session session;

	public HibernateSaleTransactionsDao(Session session) {
		this.session = session;
	}
	
	@Override
	public void save(SaleTransaction saleTransaction) {
		session.save(saleTransaction);
	}

	@Override
	public SaleTransaction findBy(Long id) {
		return session.get(SaleTransaction.class, id);
	}

}
