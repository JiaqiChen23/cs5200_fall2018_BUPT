package edu.northeastern.cs5200.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Player {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@ManyToOne()
	@JsonIgnore
	private Fan fans;
	
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
	public Fan getFans() {
		return fans;
	}
	public void setFans(Fan fans) {
		this.fans = fans;
	}
	public Player(int id, String name, int width, int height, String cssclass, String cssstyle,
			String text, int ordernum, Team page)
	{
		this.id = id;
		this.name = name;
	}
		
		 
}
