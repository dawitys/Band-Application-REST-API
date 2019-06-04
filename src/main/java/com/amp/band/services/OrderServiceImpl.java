package com.amp.band.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amp.band.domains.Order;
import com.amp.band.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Iterable<Order> saveAll(Iterable<Order> orders) {
		return orderRepository.saveAll(orders);
	}

	@Override
	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return orderRepository.existsById(id);
	}

	@Override
	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Iterable<Order> findAllById(Iterable<Long> ids) {
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
	public void delete(Order order) {
		orderRepository.delete(order);
	}

	@Override
	public void deleteAll(Iterable<Order> orders) {
		orderRepository.deleteAll(orders);

	}

	@Override
	public void deleteAll() {
		orderRepository.deleteAll();
	}

}
