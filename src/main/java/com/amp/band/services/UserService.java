package com.amp.band.services;

import java.util.Optional;
import com.amp.band.domains.User;

public interface UserService {

	public User save(User user);
	
	public Iterable<User> saveAll(Iterable<User> users);

	Optional<User> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<User> findAll();

	Iterable<User> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(User user);
	
	void deleteAll(Iterable<User> users);

	void deleteAll();
}
