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
	public Long id;
	
	public Date createdAt;
	
	@ManyToOne
	@JoinColumn(name="band_id")
	public Band eventBy;
	
	@Column(name="event_time")
	public Date time;
	
	@Column(name = "event_place")
	public String place;
   	
	@Column(name="geo_location")
	public String geoLocation;
	
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
}

