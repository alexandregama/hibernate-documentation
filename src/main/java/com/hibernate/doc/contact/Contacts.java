package com.hibernate.doc.contact;

import java.util.Optional;

public interface Contacts {

	void save(Contact contact);
	
	Optional<Contact> findContactByIts(Long id);
	
}
