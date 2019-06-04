package com.amp.band.repositories;

import org.springframework.data.repository.CrudRepository;
import com.amp.band.domains.Review;

public interface ReviewRepository extends CrudRepository<Review, Long>{
}
