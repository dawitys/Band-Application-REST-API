package com.amp.band.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amp.band.domains.Schedule;
import com.amp.band.repositories.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	ScheduleRepository scheduleRepository;
	
	@Autowired
	public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}

	@Override
	public Schedule save(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	@Override
	public Iterable<Schedule> saveAll(Iterable<Schedule> schedules) {
		return scheduleRepository.saveAll(schedules);
	}

	@Override
	public Optional<Schedule> findById(Long id) {
		return scheduleRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return scheduleRepository.existsById(id);
	}

	@Override
	public Iterable<Schedule> findAll() {
		return scheduleRepository.findAll();
	}

	@Override
	public Iterable<Schedule> findAllById(Iterable<Long> ids) {
		return scheduleRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return scheduleRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		scheduleRepository.deleteById(id);
	}

	@Override
	public void delete(Schedule schedule) {
		scheduleRepository.delete(schedule);
	}

	@Override
	public void deleteAll(Iterable<Schedule> schedules) {
		scheduleRepository.deleteAll(schedules);

	}

	@Override
	public void deleteAll() {
		scheduleRepository.deleteAll();
	}

}
