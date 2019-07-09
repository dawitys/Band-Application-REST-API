package com.amp.band.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.amp.band.domains.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	public Optional<User> findByUsername(String username);
	
}