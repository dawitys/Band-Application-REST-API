package com.amp.band.services;

import java.util.Optional;
import com.amp.band.domains.Musician;

public interface MusicianService {
	
	public Musician save(Musician musician);
	
	public Iterable<Musician> saveAll(Iterable<Musician> ingredients);

	Optional<Musician> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Musician> findAll();

	Iterable<Musician> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Musician musician);
	
	void deleteAll(Iterable<Musician> musicians);

	void deleteAll();
}
