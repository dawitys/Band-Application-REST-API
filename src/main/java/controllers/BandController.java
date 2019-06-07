package controllers;


import java.util.Optional;
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
	  
	  @PostMapping("/{bid}/members/")
	  public void adduserToBand(@RequestBody User user,@Param("bid") Long bid) {
		    Optional<Band> optionalBand = bandRepository.findById(bid);
		    try {
		    	Band band=optionalBand.get();
		    	//band.getMembers().add(user);		    	
		    }catch(Exception e){
		    	
		    }
		    //HttpHeaders headers = new HttpHeaders();
		    //headers.setLocation(URI.create("http://localhost:8080/ingredients/" + ingredient.getId()));
		    //return new ResponseEntity<>(user, HttpStatus.CREATED);
		  }
}