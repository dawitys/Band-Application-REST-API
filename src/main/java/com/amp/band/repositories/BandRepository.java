package com.amp.band.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.amp.band.domains.Band;

public interface BandRepository extends CrudRepository<Band, Long>{
	
	//@Query("SELECT * FROM bands INNER JOIN bands_members ON bands.id=bands_members.band_id WHERE bands_members.members_id= :uid")
	//@Query("SELECT * FROM bands WHERE leader_id=?1")
	//public Iterable<Band> findAllByLeader(Long uid); :userId,:bandId
	//@Modifying
	//@Query(value="INSERT INTO band_members VALUES (?1,?2)",nativeQuery=true)
	//public void InsertUserToBand(@Param("userId") Long uid,@Param("bandId") Long bid);
}
