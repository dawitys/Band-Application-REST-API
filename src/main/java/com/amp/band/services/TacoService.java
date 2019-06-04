package com.amp.band.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.amp.band.domains.Taco;

public interface TacoService {

	public Taco save(Taco ingredient);
	
	public Iterable<Taco> saveAll(Iterable<Taco> tacos);

	Optional<Taco> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Taco> findAll();

	Iterable<Taco> findAllById(Iterable<Long> ids);
	
	Iterable<Taco> findAll(Sort sort);
	
	Page<Taco> findAll(Pageable pageable);

	long count();
	
	void deleteById(Long id);
	
	void delete(Taco taco);
	
	void deleteAll(Iterable<Taco> tacos);

	void deleteAll();
}
