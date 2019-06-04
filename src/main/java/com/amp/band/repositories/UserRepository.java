package com.amp.band.repositories;

import org.springframework.data.repository.CrudRepository;
import com.amp.band.domains.User;

public interface UserRepository extends CrudRepository<User, Long>{
}