package edu.northeastern.cs5200.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Person")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	@Column(name = "firstname", nullable = false)
	protected String firstname;
	@Column(name = "lastname", nullable = false)
	protected String lastname;
	@Column(name = "username", nullable = false)
	protected String username;
	@Column(name = "password", nullable = false)
	protected String password;
	@Column(name = "email", nullable = false)
	protected String email;
	protected Date dob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Person(int id, String firstname, String lastname, 
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
	public Person() {
		super();
	}
	
}
