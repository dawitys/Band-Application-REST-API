package com.amp.band.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.amp.band.domains.Event;

public interface EventRepository extends CrudRepository<Event, Long>{

	@Query(value="select * from events left outer join bands_members on events.band_id=bands_members.bands_id where bands_members.members_id=?1",
			nativeQuery=true)
	public List<Event> findAllByMemberId(Long mid);
	
}
