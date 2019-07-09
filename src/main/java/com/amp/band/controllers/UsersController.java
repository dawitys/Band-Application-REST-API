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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.amp.band.domains.Band;
import com.amp.band.domains.User;
import com.amp.band.repositories.BandRepository;
import com.amp.band.repositories.UserRepository;

@RestController
@RequestMapping(path="/", produces="application/json")
@CrossOrigin(origins="*")
public class UsersController {

	private UserRepository userService;
	private BandRepository bandService;
	
	public UsersController(UserRepository userService,BandRepository bandService) {
		this.userService = userService;
		this.bandService=bandService;
	}
	
	@GetMapping("/users")
	public Iterable<User> Allusers(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> userById(@PathVariable("id") Long id){
		Optional<User> user = userService.findById(id);
		if(user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	@GetMapping("/users/search/findByUsername{username}")
	public ResponseEntity<User> userById(@PathVariable("username") String uname){
		Optional<User> user = userService.findByUsername(uname);
		if(user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	@GetMapping("/users/{u}/members")
	public Iterable<User> userByBandId(@PathVariable("id") Long id){
		Iterable<User> members = null;
		Optional<Band> band = bandService.findById(id);
		if(band.isPresent()) {
			//members= band.get().members;
		}
		return members;
	}
	
	@GetMapping("/bands/{bid}/leader")
	public ResponseEntity<User> leaderByBandId(@PathVariable("id") Long id){
		Optional<Band> band = bandService.findById(id);
		if(band.isPresent()) {
			//return new ResponseEntity<>(band.get().leader, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(path="/users", consumes="application/json")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User savedUser = userService.save(user);
		if(savedUser != null) {			
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PatchMapping(path="/users/{userId}", consumes="application/json")
	public ResponseEntity<User> partialStudentUpdate(@PathVariable("userId") Long id, @RequestBody User partialUser) {
		
		User user = userService.findById(id).get();
		
		if(user != null) {
			if(partialUser.name!= null) {
				user.name=partialUser.name;
			}
			
			if(partialUser.majorSkill!=null) {
				user.majorSkill=partialUser.majorSkill;
			}
			
			if(partialUser.skills!= null) {
				user.skills=partialUser.skills;
			}
			
			if(partialUser.password != null) {
				user.password=partialUser.password;
			}
						
			if(partialUser.username != null) {
				user.username=partialUser.username;
			}
		}
		
		User savedUser = userService.save(user);
		if(savedUser != null) {			
			return new ResponseEntity<>(savedUser, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		 
	}
	@DeleteMapping(path="users/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteStudent(@PathVariable("uid") Long id){
		try {
			userService.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			
		}
		
	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestParam(name="username", defaultValue="") String username, @RequestParam(name="password", defaultValue="") String password){
		Optional<User> user = userService.findByUsername(username);
		
		if(user.isPresent() && user.get().password.equals(password)) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
		

}