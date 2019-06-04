package com.amp.band.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.amp.band.domains.Schedule;

public interface ScheduleRepository extends PagingAndSortingRepository<Schedule, Long>{
}