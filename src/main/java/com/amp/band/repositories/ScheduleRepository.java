package com.amp.band.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.amp.band.domains.Band;
import com.amp.band.domains.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Long>{
	
	//@Query("SELECT s FROM schedules s WHERE s.band_id= ?1")
	//public Iterable<Schedule> findAllByscheduledBy(Long bid);
}