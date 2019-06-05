package com.amp.band.services;

import java.util.Optional;
import com.amp.band.domains.Schedule;

public interface ScheduleService {

	public Schedule save(Schedule schedule);
	
	public Iterable<Schedule> saveAll(Iterable<Schedule> schedules);

	Optional<Schedule> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Schedule> findAll();

	Iterable<Schedule> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Schedule schedule);
	
	void deleteAll(Iterable<Schedule> schedules);

	void deleteAll();
}
