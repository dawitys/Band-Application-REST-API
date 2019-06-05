package com.amp.band.domains;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name="band_id")
	private Band eventBy;
	
	@Column(name="event_time")
	private Date time;
	
	@Column(name = "event_place")
	private String place;
   	
	@Column(name="geo_location")
	private String geoLocation;
	
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
}

