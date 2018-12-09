package edu.northeastern.cs5200.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="draft")
public class Draft {
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JsonIgnore
	private Team team;
	
	@ManyToOne()
	@JsonIgnore
	private Player player;
	private String year;
	private int orderNum;
	
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getOrder() {
		return orderNum;
	}

	public void setOrder(int order) {
		this.orderNum = order;
	}

	public Draft(int id, String name, Team team, String year, int order) {
		super();
		this.id = id;
		this.team = team;
		this.year = year;
		this.orderNum = order;
	}
}
