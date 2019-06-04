package com.amp.band.repositories;

import org.springframework.data.repository.CrudRepository;

import com.amp.band.domains.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
