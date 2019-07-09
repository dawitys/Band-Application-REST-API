package com.amp.band.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.amp.band.domains.Band;

public interface BandRepository extends CrudRepository<Band, Long>{
	//@Query("SELECT u FROM bands JOIN bands_members ON bands.id=bands_members.band_id u WHERE u.members_id = ?1")
	//Iterable<Band> findByUserId(long id);
}
