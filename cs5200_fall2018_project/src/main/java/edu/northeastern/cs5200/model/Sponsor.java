package edu.northeastern.cs5200.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Sponsor extends Person{

//	@Id  
//	@GeneratedValue
//	   (strategy=GenerationType.IDENTITY)
//	private int id;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Team team;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Sponsor(int id, String firstname, String lastname, 
			String username, String password, String email, Date dob,
			Team team) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.team = team;
	}
	public Sponsor() {
		super();
	}
}
