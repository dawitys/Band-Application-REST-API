package com.amp.band.services;

import java.util.Optional;

import com.amp.band.domains.Event;

public interface EventService {

	public Event save(Event event);
	
	public Iterable<Event> saveAll(Iterable<Event> events);

	Optional<Event> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Event> findAll();

	Iterable<Event> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Event event);
	
	void deleteAll(Iterable<Event> events);

	void deleteAll();
}
