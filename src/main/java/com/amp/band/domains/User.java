package com.amp.band.domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Constraint;

import lombok.Data;

@Data
@Entity
@Table(name = "users",
	uniqueConstraints=@UniqueConstraint(columnNames = { "username" }
	)
)
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    
    private String password;

	@Column(name="full_name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Skill majorSkill;
	
	private String skills;
	
	@ManyToMany(mappedBy = "members")
    private List<Band> bands;
	
	public static enum Skill {
		VOCALIST, BASSIST, PIANIST, GUITARIST, DRUMMER, KEYBOARDIST,MUSICIAN
	}
}

   