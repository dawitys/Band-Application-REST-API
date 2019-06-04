package com.amp.band.repositories;

import org.springframework.data.repository.CrudRepository;
import com.amp.band.domains.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Long>{
}