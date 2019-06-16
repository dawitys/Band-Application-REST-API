package com.amp.band.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.amp.band.domains.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Long>{
	
	@Query(value="select * from schedules left outer join bands_members on schedules.band_id=bands_members.bands_id where bands_members.members_id=?1",
			nativeQuery=true)
	public List<Schedule> findAllByMemberId(Long mid);

}