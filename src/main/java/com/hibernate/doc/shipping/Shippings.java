package com.hibernate.doc.shipping;

import java.util.Optional;

public interface Shippings {

	void save(Shipping shipping);

	Optional<Shipping> findBy(Long id);
	
}
