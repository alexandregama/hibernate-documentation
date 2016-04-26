package com.hibernate.doc.any;

public interface SaleTransactions {

	void save(SaleTransaction saleTransaction);
	
	SaleTransaction findBy(Long id);
	
}
