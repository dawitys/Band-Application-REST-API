package com.amp.band.services;

import java.util.Optional;
import com.amp.band.domains.Review;

public interface ReviewService {

	public Review save(Review review);
	
	public Iterable<Review> saveAll(Iterable<Review> reviews);

	Optional<Review> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Review> findAll();

	Iterable<Review> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Review review);
	
	void deleteAll(Iterable<Review> reviews);

	void deleteAll();
}
