package edu.northeastern.cs5200.model;

import java.util.Collection;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name = "fans")
public class Fan extends Person{

//	@Id  
//	@GeneratedValue
//	   (strategy=GenerationType.IDENTITY)
//	private int id;
	
	@OneToMany(mappedBy="fans")
	private List<Allstar> voted;
	public void voted(Allstar allstar)
	{    this.voted.add(allstar);
	     if(allstar.getFans() != this) {
	        allstar.setFans(this);
	}}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<Allstar> getVoted() {
		return voted;
	}


	public void setVoted(List<Allstar> voted) {
		this.voted = voted;
	}


	public Fan(int id, String firstname, String lastname, 
			String username, String password, String email, Date dob,
			List<Allstar> voted) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.voted = voted;
	}
	public Fan(int id, String firstname, String lastname, 
			String username, String password, String email, Date dob) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}

	public Fan() {
		super();
	}

	

}
