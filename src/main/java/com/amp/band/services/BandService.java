package com.amp.band.services;

import java.util.Optional;
import com.amp.band.domains.Band;

public interface BandService {

	public Band save(Band band);
	
	public Iterable<Band> saveAll(Iterable<Band> bands);

	Optional<Band> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Band> findAll();

	Iterable<Band> findAllById(Iterable<Long> ids);
	
	long count();
	
	void deleteById(Long id);
	
	void delete(Band band);
	
	void deleteAll(Iterable<Band> bands);

	void deleteAll();
}
