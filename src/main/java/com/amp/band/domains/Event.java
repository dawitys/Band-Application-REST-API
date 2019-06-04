package com.amp.band.domains;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;


@Data
@Entity
@Table(name="taco_order")
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date placedAt;
	
	@PrePersist
	void placedAt() {
		this.placedAt = new Date();
	}	
	
	@Column(name = "first_name")
    @NotBlank(message = "Please provide your first name")
    private String firstName;
    
    @Column(name = "last_name")
    @NotBlank(message = "Please provide your last name")
    private String lastName;
  
	@NotBlank(message="Delivery Street is required")
  	private String deliveryStreet;
  
	@NotBlank(message="City is required")
	private String deliveryCity;
  
	@NotBlank(message="State is required")
	private String deliveryState;
  
	@NotBlank(message="Zip code is required")
	private String deliveryZip; 
  
	@CreditCardNumber(message="Not a valid credit card number")
	private String ccNumber;
  
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message="Must be formatted MM/YY")
	private String ccExpiration;
  
	@Digits(integer=3, fraction=0, message="Invalid CVV")
	private String ccCVV;
	
	@ManyToMany
	private Set<Band> tacos = new HashSet<>();
	
	public void addTacoDesign(Band tacoDesign) {
		this.tacos.add(tacoDesign);
	}

}

