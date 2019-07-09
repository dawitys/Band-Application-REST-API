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

import com.amp.band.domains.Schedule;
import com.amp.band.repositories.ScheduleRepository;
import com.amp.band.repositories.UserRepository;

@RestController
@RequestMapping(path="/", produces="application/json")
@CrossOrigin(origins="*")
public class SchedulesController {

	private UserRepository userService;
	private ScheduleRepository scheduleService;
	
	public SchedulesController(UserRepository userService,ScheduleRepository scheduleService) {
		this.userService = userService;
		this.scheduleService=scheduleService;
	}
	
	@GetMapping("/schedules")
	public Iterable<Schedule> AllSchedules(){
		return scheduleService.findAll();
	}
	
	@GetMapping("/schedules/{id}")
	public ResponseEntity<Schedule> ScheduleById(@PathVariable("id") Long id){
		Optional<Schedule> schedule = scheduleService.findById(id);
		if(schedule.isPresent()) {
			return new ResponseEntity<>(schedule.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/users/{u}/schedules")
	public Iterable<Schedule> scheduleByUserId(@PathVariable("id") Long id){
		Iterable<Schedule> members = null;
		return members;
	}
	@PostMapping(path="/schedules", consumes="application/json")
	public ResponseEntity<Schedule> saveSchedule(@RequestBody Schedule schedule) {
		Schedule savedSchedule = scheduleService.save(schedule);
		if(savedSchedule != null) {			
			return new ResponseEntity<>(savedSchedule, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	@PatchMapping(path="/schedules/{scheduleId}", consumes="application/json")
	public ResponseEntity<Schedule> partialStudentUpdate(@PathVariable("scheduleId") Long id, @RequestBody Schedule partialSchedule) {
		
		Schedule schedule = scheduleService.findById(id).get();
		
		if(schedule != null) {
			if(partialSchedule.geoLocation!= null) {
				schedule.geoLocation=partialSchedule.geoLocation;
			}
			
			if(partialSchedule.place!=null) {
				schedule.place=partialSchedule.place;
			}
			
			if(partialSchedule.time!= null) {
				schedule.time=partialSchedule.time;
			}
			
		}
		
		Schedule savedSchedule = scheduleService.save(schedule);
		if(savedSchedule != null) {			
			return new ResponseEntity<>(savedSchedule, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		 
	}
	@DeleteMapping(path="schedules/{scheduleId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteStudent(@PathVariable("uid") Long id){
		try {
			scheduleService.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			
		}
		
	}
}