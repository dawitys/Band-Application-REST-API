package com.amp.band.services;

import java.util.Optional;

import com.amp.band.domains.Event;

public interface OrderService {

	public Event save(Event order);
	
	public Iterable<Event> saveAll(Iterable<Event> orders);

	Optional<Event> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Event> findAll();

	Iterable<Event> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Event order);
	
	void deleteAll(Iterable<Event> orders);

	void deleteAll();
}
