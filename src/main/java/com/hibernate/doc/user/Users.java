package com.hibernate.doc.user;

import java.util.Optional;

public interface Users {

	void save(User user);
	
	Optional<User> findBy(Long id);
	
}
