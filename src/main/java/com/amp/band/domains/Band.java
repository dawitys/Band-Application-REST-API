package com.amp.band.domains;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bands")
public class Band {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	public Date createdAt;
	
	@Column(name="band_name")
	public String name;
	
	@Column(name="genre")
	public String genre;
	
	//@ManyToOne
	//@JoinColumn(name="leader_id")
	//public User leader;
	
	@Column(name="contact_info")
	public String contactInfo;
	
	//@ManyToMany(mappedBy ="bands")
	//public List<User> members;
	
	//@OneToMany(mappedBy = "eventBy")
    //public List<Event> events;
	
	//@OneToMany(mappedBy = "scheduledBy")
    //public List<Schedule> schedules;
	
	//@OneToMany(mappedBy = "reviewedBand")
    //public List<Review> reviews;
	
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}

}
