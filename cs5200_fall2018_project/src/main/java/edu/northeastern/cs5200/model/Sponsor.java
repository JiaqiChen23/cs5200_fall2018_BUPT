package edu.northeastern.cs5200.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Sponsor extends Person{

	@Id  
	@GeneratedValue
	   (strategy=GenerationType.IDENTITY)
	private int id;
	private String sponsored;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Team team;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSponsored() {
		return sponsored;
	}
	public void setSponsored(String sponsored) {
		this.sponsored = sponsored;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
}
