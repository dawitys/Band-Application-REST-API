package com.amp.band.domains;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	private Long id;
	
	private Date createdAt;
	
	@Column(name="band_name")
	private String name;
	
	@Column(name="genre")
	private String genre;
	
	@ManyToOne
	@JoinColumn(name="leader_id")
	private Musician leader;
	
	@Column(name="contact_info")
	private String contactInfo;
	
	@ManyToMany
	private Set<Musician> members = new HashSet<>();
	
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}

}
