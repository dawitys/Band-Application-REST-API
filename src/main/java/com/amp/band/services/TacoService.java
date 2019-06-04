package com.amp.band.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.amp.band.domains.Band;

public interface TacoService {

	public Band save(Band ingredient);
	
	public Iterable<Band> saveAll(Iterable<Band> tacos);

	Optional<Band> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Band> findAll();

	Iterable<Band> findAllById(Iterable<Long> ids);
	
	Iterable<Band> findAll(Sort sort);
	
	Page<Band> findAll(Pageable pageable);

	long count();
	
	void deleteById(Long id);
	
	void delete(Band taco);
	
	void deleteAll(Iterable<Band> tacos);

	void deleteAll();
}
