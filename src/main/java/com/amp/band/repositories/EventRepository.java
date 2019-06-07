package com.amp.band.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.amp.band.domains.Band;
import com.amp.band.domains.Event;

public interface EventRepository extends CrudRepository<Event, Long>{

	//@Query("SELECT e FROM events e WHERE e.band_id= ?1")
	public List<Event> findAllByeventBy(Band bid);
	
	//public String findAllByEventBy(Long bid);
}
