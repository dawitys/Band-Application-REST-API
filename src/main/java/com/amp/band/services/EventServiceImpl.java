package com.amp.band.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amp.band.domains.Event;
import com.amp.band.repositories.EventRepository;

@Service
public class EventServiceImpl implements EventService {
	
	EventRepository eventRepository;
	
	@Autowired
	public EventServiceImpl(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Override
	public Event save(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public Iterable<Event> saveAll(Iterable<Event> events) {
		return eventRepository.saveAll(events);
	}

	@Override
	public Optional<Event> findById(Long id) {
		return eventRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return eventRepository.existsById(id);
	}

	@Override
	public Iterable<Event> findAll() {
		return eventRepository.findAll();
	}

	@Override
	public Iterable<Event> findAllById(Iterable<Long> ids) {
		return eventRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return eventRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		eventRepository.deleteById(id);
	}

	@Override
	public void delete(Event event) {
		eventRepository.delete(event);
	}

	@Override
	public void deleteAll(Iterable<Event> events) {
		eventRepository.deleteAll(events);

	}

	@Override
	public void deleteAll() {
		eventRepository.deleteAll();
	}

}
