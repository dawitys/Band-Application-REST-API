package com.amp.band.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amp.band.domains.Event;
import com.amp.band.repositories.MusicianRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	MusicianRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(MusicianRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Event save(Event order) {
		return orderRepository.save(order);
	}

	@Override
	public Iterable<Event> saveAll(Iterable<Event> orders) {
		return orderRepository.saveAll(orders);
	}

	@Override
	public Optional<Event> findById(Long id) {
		return orderRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return orderRepository.existsById(id);
	}

	@Override
	public Iterable<Event> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Iterable<Event> findAllById(Iterable<Long> ids) {
		return orderRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return orderRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		orderRepository.deleteById(id);
	}

	@Override
	public void delete(Event order) {
		orderRepository.delete(order);
	}

	@Override
	public void deleteAll(Iterable<Event> orders) {
		orderRepository.deleteAll(orders);

	}

	@Override
	public void deleteAll() {
		orderRepository.deleteAll();
	}

}
