package com.amp.band.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amp.band.domains.Ingredient;
import com.amp.band.repositories.IngredientRepository;

@Service
public class IngredientServiceImpl implements IngredientService {

	IngredientRepository ingredientRepository;
	
	@Autowired
	public IngredientServiceImpl(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}
	
	@Override
	public Ingredient save(Ingredient ingredient) {
		
		return ingredientRepository.save(ingredient);
		
	}

	@Override
	public Iterable<Ingredient> saveAll(Iterable<Ingredient> ingredients) {
		
		return ingredientRepository.saveAll(ingredients);
		
	}

	@Override
	public Optional<Ingredient> findById(Long id) {

		return ingredientRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		
		return ingredientRepository.existsById(id);
		
	}

	@Override
	public Iterable<Ingredient> findAll() {
		
		return ingredientRepository.findAll();
		
	}

	@Override
	public Iterable<Ingredient> findAllById(Iterable<Long> ids) {

		return ingredientRepository.findAllById(ids);
		
	}

	@Override
	public long count() {
		
		return ingredientRepository.count();
		
	}

	@Override
	public void deleteById(Long id) {
		
		ingredientRepository.deleteById(id);
		
	}

	@Override
	public void delete(Ingredient ingredient) {
		
		ingredientRepository.delete(ingredient);

	}

	@Override
	public void deleteAll(Iterable<Ingredient> ingredients) {

		ingredientRepository.deleteAll(ingredients);
		
	}

	@Override
	public void deleteAll() {

		ingredientRepository.deleteAll();
		
	}

}
