package edu.northeastern.cs5200.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne()
	@JsonIgnore
	private Team team;
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, 
	        mappedBy = "player")
	private Draft draft;
	
	@OneToMany(mappedBy="player")
	private List<Allstar> voted;
	public void voted(Allstar allstar)
	{    this.voted.add(allstar);
	     if(allstar.getPlayer() != this) {
	        allstar.setPlayer(this);
	}}
	

	public Draft getDraft() {
		return draft;
	}


	public void setDraft(Draft draft) {
		this.draft = draft;
	}


	public List<Allstar> getVoted() {
		return voted;
	}

	public void setVoted(List<Allstar> voted) {
		this.voted = voted;
	}

	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
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
	public Player(int id, String name, Team team)
	{
		this.id = id;
		this.name = name;
		this.team = team;
	}

	public Player() {
		super();
	}
		
		 
}
