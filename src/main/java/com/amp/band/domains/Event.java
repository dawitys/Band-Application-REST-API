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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;


@Data
@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date createdAt;
	
	@Column(name="event_time")
	private Date eventTime;
	
	@Column(name = "event_place")
	private String eventPlace;
   	
	@Column(name="geo_location")
	private String geoLocation;
	
	@PrePersist
	void placedAt() {
		this.createdAt = new Date();
	}
}

