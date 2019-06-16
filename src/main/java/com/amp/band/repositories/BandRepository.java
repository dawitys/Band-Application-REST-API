package com.amp.band.repositories;

import org.springframework.data.repository.CrudRepository;
import com.amp.band.domains.Band;

public interface BandRepository extends CrudRepository<Band, Long>{

}
