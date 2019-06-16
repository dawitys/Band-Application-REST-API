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
    public Long id;
    
    public String username;
    
    public String password;

	@Column(name="full_name")
	public String name;
	
	@Enumerated(EnumType.STRING)
	public Skill majorSkill;
	
	public String skills;
	
	@ManyToMany(mappedBy = "members")
    public List<Band> bands;
	
	public static enum Skill {
		VOCALIST, BASSIST, PIANIST, GUITARIST, DRUMMER, KEYBOARDIST,MUSICIAN
	}
}

   