package com.amp.band.controllers;

import java.util.Optional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.amp.band.domains.Event;
import com.amp.band.repositories.EventRepository;
import com.amp.band.repositories.UserRepository;

@RestController
@RequestMapping(path="/", produces="application/json")
@CrossOrigin(origins="*")
public class EventsController {

	private UserRepository userService;
	private EventRepository eventService;
	
	public EventsController(UserRepository userService,EventRepository eventService) {
		this.userService = userService;
		this.eventService=eventService;
	}
	
	@GetMapping("/events")
	public Iterable<Event> AllEvents(){
		return eventService.findAll();
	}
	
	@GetMapping("/events/{id}")
	public ResponseEntity<Event> EventById(@PathVariable("id") Long id){
		Optional<Event> event = eventService.findById(id);
		if(event.isPresent()) {
			return new ResponseEntity<>(event.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/users/{u}/events")
	public Iterable<Event> eventByUserId(@PathVariable("id") Long id){
		Iterable<Event> members = null;
		return members;
	}
	@PostMapping(path="/events", consumes="application/json")
	public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
		Event savedEvent = eventService.save(event);
		if(savedEvent != null) {			
			return new ResponseEntity<>(event, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	@PatchMapping(path="/events/{eventId}", consumes="application/json")
	public ResponseEntity<Event> partialStudentUpdate(@PathVariable("eventId") Long id, @RequestBody Event partialEvent) {
		
		Event event = eventService.findById(id).get();
		
		if(event != null) {
			if(partialEvent.geoLocation!= null) {
				event.geoLocation=partialEvent.geoLocation;
			}
			
			if(partialEvent.place!=null) {
				event.place=partialEvent.place;
			}
			
			if(partialEvent.time!= null) {
				event.time=partialEvent.time;
			}
			
		}
		
		Event savedEvent = eventService.save(event);
		if(savedEvent != null) {			
			return new ResponseEntity<>(savedEvent, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		 
	}
	@DeleteMapping(path="events/{eventId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteStudent(@PathVariable("uid") Long id){
		try {
			eventService.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			
		}
		
	}
}