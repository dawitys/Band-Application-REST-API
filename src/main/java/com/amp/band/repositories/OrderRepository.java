package com.amp.band.repositories;

import org.springframework.data.repository.CrudRepository;

import com.amp.band.domains.Event;

public interface OrderRepository extends CrudRepository<Event, Long> {
}
