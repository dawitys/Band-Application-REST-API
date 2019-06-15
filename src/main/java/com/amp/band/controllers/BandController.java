package com.amp.band.controllers;


import java.net.URI;
import java.util.Optional;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amp.band.domains.Band;
import com.amp.band.domains.User;
import com.amp.band.repositories.BandRepository;
import com.amp.band.repositories.UserRepository;

@RestController
@RequestMapping(path="/util", produces="application/json")
@CrossOrigin(origins="*")
public class BandController {
	
	  private UserRepository userRepository;
	  private BandRepository bandRepository;

	  @Autowired
	  public BandController(UserRepository userRepository,BandRepository bandRepository) {
	    this.userRepository = userRepository;
	    this.bandRepository = bandRepository;
	  }
	  
	  @PostMapping("/{bid}/members/{uid}")
	  public ResponseEntity<User> adduserToBand(@Param("uid") Long uid,@Param("bid") Long bid) {
		    Optional<Band> optionalBand = bandRepository.findById(bid);
		    User u = null;
		    try {
		    	Band band=optionalBand.get();
		    	u=userRepository.findById(uid).get();
		    	band.members.add(u);		    	
		    }catch(Exception e){
		    	
		    }
		    HttpHeaders headers = new HttpHeaders();
		    headers.setLocation(URI.create("http://localhost:8080/user/" + u.id));
		    return new ResponseEntity<>(u, HttpStatus.CREATED);
		  }
}