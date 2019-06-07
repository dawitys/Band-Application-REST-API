package com.amp.band.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.amp.band.domains.Band;
import com.amp.band.domains.User;

public interface UserRepository extends CrudRepository<User, Long>{
	public User findByUsername(String username);
	
	//public Iterable<User>findAllByBandIn(Band band);
}