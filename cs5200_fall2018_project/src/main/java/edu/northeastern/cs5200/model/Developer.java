package edu.northeastern.cs5200.model;

import java.util.Collection;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name = "developer")
public class Developer extends person{
	@Column(name = "developerkey", nullable = false)
	private String developerKey;
	@OneToMany(mappedBy="developer")
	private List<Website> implementWeb;
	public void implementWeb(Website web)
	{    this.implementWeb.add(web);
	     if(web.getDeveloper() != this) {
	        web.setDeveloper(this);
	}}

	public String getDeveloperKey() {
		return developerKey;
	}
	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}
	public List<Website> getImplementWeb() {
		return implementWeb;
	}

	public void setImplementWeb(List<Website> implementWeb) {
		this.implementWeb = implementWeb;
	}

	
	public Developer(int id, String firstname, String lastname, 
			String username, String password, String email, Date dob, String key) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.developerKey = key;
	}
	public Developer(String firstname, String lastname, 
			String username, String password, String email, Date dob, String key) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.developerKey = key;
	}

	public Developer() {
		super();
	}

}
