package edu.northeastern.cs5200.model;

import java.util.Collection;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name = "fans")
public class Fans extends person{
	@Id  
	@GeneratedValue
	   (strategy=GenerationType.IDENTITY)
	private int id;
	@OneToMany(mappedBy="fans")
	private List<Team> followTeam;
	public void followTeam(Team t)
	{    this.followTeam.add(t);
	     if(t.getFans() != this) {
	        t.setFans(this);
	}}

	
	public List<Team> getfollowTeam() {
		return followTeam;
	}

	public void setfollowTeam(List<Team> followTeam) {
		this.followTeam = followTeam;
	}

	
	public Fans(int id, String firstname, String lastname, 
			String username, String password, String email, Date dob, String key) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}
	public Fans(String firstname, String lastname, 
			String username, String password, String email, Date dob, String key) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}

	public Fans() {
		super();
	}

}
