package com.amp.band.domains;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="musicians")
public class Musician
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
		
	@Column(name="full_name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Skill skill;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;	
	
	public static enum Skill {
		VOCALIST, BASSIST, PIANIST, GUITARIST, DRUMMER, KEYBOARDIST,MUSICIAN
	}

}
