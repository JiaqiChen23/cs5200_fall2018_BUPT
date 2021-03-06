package edu.northeastern.cs5200.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Stadium {
	@Id  
	@GeneratedValue
	   (strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Team team;
	private int Seats;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Stadium(int id, String name, Team team, int seats)
	{
		super();
		this.id = id;
		this.name = name;
		this.team = team;
		this.Seats = seats;
	}
	public Stadium() {
		super();
	}
	public int getSeats() {
		return Seats;
	}
	public void setSeats(int seats) {
		Seats = seats;
	}
}
