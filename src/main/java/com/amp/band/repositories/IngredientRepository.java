package com.amp.band.repositories;

import org.springframework.data.repository.CrudRepository;

import com.amp.band.domains.Musician;

public interface IngredientRepository extends CrudRepository<Musician, Long>{
}
