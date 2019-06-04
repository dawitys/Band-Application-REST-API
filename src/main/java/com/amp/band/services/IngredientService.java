package com.amp.band.services;

import java.util.Optional;

import com.amp.band.domains.Ingredient;

public interface IngredientService {
	
	public Ingredient save(Ingredient ingredient);
	
	public Iterable<Ingredient> saveAll(Iterable<Ingredient> ingredients);

	Optional<Ingredient> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Ingredient> findAll();

	Iterable<Ingredient> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Ingredient ingredient);
	
	void deleteAll(Iterable<Ingredient> ingredients);

	void deleteAll();
}
