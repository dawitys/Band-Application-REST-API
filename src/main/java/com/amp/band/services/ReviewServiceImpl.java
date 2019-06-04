package com.amp.band.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amp.band.domains.Review;
import com.amp.band.repositories.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	ReviewRepository reviewRepository;
	
	@Autowired
	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	@Override
	public Review save(Review review) {
		return reviewRepository.save(review);
	}

	@Override
	public Iterable<Review> saveAll(Iterable<Review> reviews) {
		return reviewRepository.saveAll(reviews);
	}

	@Override
	public Optional<Review> findById(Long id) {
		return reviewRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return reviewRepository.existsById(id);
	}

	@Override
	public Iterable<Review> findAll() {
		return reviewRepository.findAll();
	}

	@Override
	public Iterable<Review> findAllById(Iterable<Long> ids) {
		return reviewRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return reviewRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		reviewRepository.deleteById(id);
	}

	@Override
	public void delete(Review review) {
		reviewRepository.delete(review);
	}

	@Override
	public void deleteAll(Iterable<Review> reviews) {
		reviewRepository.deleteAll(reviews);

	}

	@Override
	public void deleteAll() {
		reviewRepository.deleteAll();
	}

}
