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

import org.springframework.data.rest.core.annotation.RestResource;
import lombok.Data;

@Data
@Entity
@RestResource(rel="bands", path="bands")
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
	
	@ManyToOne
	@JoinColumn(name="leader_id")
	public User leader;
	
	@Column(name="contact_info")
	public String contactInfo;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "band_members", 
		      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
		      inverseJoinColumns = @JoinColumn(name = "band_id", 
		      referencedColumnName = "id"))
	public List<User> members;
	
	@OneToMany(mappedBy = "eventBy")
    public List<Event> events;
	
	@OneToMany(mappedBy = "scheduledBy")
    public List<Schedule> schedules;
	
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}

}
