package com.amp.band.services;

import java.util.Optional;

import com.amp.band.domains.Order;

public interface OrderService {

	public Order save(Order order);
	
	public Iterable<Order> saveAll(Iterable<Order> orders);

	Optional<Order> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Order> findAll();

	Iterable<Order> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Order order);
	
	void deleteAll(Iterable<Order> orders);

	void deleteAll();
}
