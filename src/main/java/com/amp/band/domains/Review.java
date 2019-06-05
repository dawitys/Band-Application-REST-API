package com.amp.band.domains;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="reviews")
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date createdAt;
	
	@OneToOne(cascade = CascadeType.ALL)
    	@JoinColumn(name = "user_id")
    	private User user;	
	
	@OneToOne(cascade = CascadeType.ALL)
    	@JoinColumn(name = "band_id")
    	private Band band;	
	
	@Column(name = "review_value")
	private String value;
	
	@Column(name = "review_content")
	private String content;
    
	@PrePersist
	void placedAt() {
		this.createdAt = new Date();
	}
}
