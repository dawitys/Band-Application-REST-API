package com.amp.band.repositories;

import org.springframework.data.repository.CrudRepository;

import com.amp.band.domains.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
}
