package com.amp.band.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
		
	@Column(name = "review_value")
	private String value;
	
	@Column(name = "review_content")
	private String content;
    
	@PrePersist
	void placedAt() {
		this.createdAt = new Date();
	}
}
