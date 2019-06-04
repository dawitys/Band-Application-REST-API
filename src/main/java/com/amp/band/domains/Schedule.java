package com.amp.band.domains;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="schedules")
public class Schedule{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date createdAt;
	
	@Column(name="schedule_time")
	private Date scheduleTime;
	
	@Column(name = "schedule_place")
	private String schedulePlace;
   	
	@Column(name="geo_location")
	private String geoLocation;
	
	@Column(name="schedule_type")
	private String scheduletype;
	
	@PrePersist
	void placedAt() {
		this.createdAt = new Date();
	}
}

