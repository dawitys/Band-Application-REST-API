package com.amp.band.repositories;

import org.springframework.data.repository.CrudRepository;
import com.amp.band.domains.Musician;

public interface MusicianRepository extends CrudRepository<Musician, Long> {
}
