package com.amp.band.services;

import java.util.Optional;

import com.amp.band.domains.Musician;

public interface IngredientService {
	
	public Musician save(Musician ingredient);
	
	public Iterable<Musician> saveAll(Iterable<Musician> ingredients);

	Optional<Musician> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Musician> findAll();

	Iterable<Musician> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Musician ingredient);
	
	void deleteAll(Iterable<Musician> ingredients);

	void deleteAll();
}
