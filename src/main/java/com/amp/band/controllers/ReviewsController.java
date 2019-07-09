package com.amp.band.controllers;

import java.util.Optional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.amp.band.domains.Review;
import com.amp.band.repositories.ReviewRepository;
import com.amp.band.repositories.UserRepository;

@RestController
@RequestMapping(path="/", produces="application/json")
@CrossOrigin(origins="*")
public class ReviewsController {

	private UserRepository userService;
	private ReviewRepository reviewService;
	
	public ReviewsController(UserRepository userService,ReviewRepository reviewService) {
		this.userService = userService;
		this.reviewService=reviewService;
	}
	
	@GetMapping("/reviews")
	public Iterable<Review> AllReviews(){
		return reviewService.findAll();
	}
	
	@GetMapping("/reviews/{id}")
	public ResponseEntity<Review> ReviewById(@PathVariable("id") Long id){
		Optional<Review> review = reviewService.findById(id);
		if(review.isPresent()) {
			return new ResponseEntity<>(review.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/users/{u}/reviews")
	public Iterable<Review> reviewByUserId(@PathVariable("id") Long id){
		Iterable<Review> members = null;
		return members;
	}
	@PostMapping(path="/reviews", consumes="application/json")
	public ResponseEntity<Review> saveReview(@RequestBody Review review) {
		Review savedReview = reviewService.save(review);
		if(savedReview != null) {			
			return new ResponseEntity<>(review, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	@PatchMapping(path="/reviews/{reviewId}", consumes="application/json")
	public ResponseEntity<Review> partialStudentUpdate(@PathVariable("reviewId") Long id, @RequestBody Review partialReview) {
		
		Review review = reviewService.findById(id).get();
		
		if(review != null) {
			if(partialReview.value!= -1) {
				review.value=partialReview.value;
			}
			
			if(partialReview.content!=null) {
				review.content=partialReview.content;
			}			
		}
		
		Review savedReview = reviewService.save(review);
		if(savedReview != null) {			
			return new ResponseEntity<>(savedReview, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		 
	}
	@DeleteMapping(path="reviews/{reviewId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteStudent(@PathVariable("uid") Long id){
		try {
			reviewService.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			
		}
		
	}
}