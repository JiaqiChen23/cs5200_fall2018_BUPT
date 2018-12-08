package edu.northeastern.cs5200.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="team")
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	@ManyToOne()
	@JsonIgnore
	private Fan fans;
	
	@OneToMany(mappedBy="team")
	private List<Draft> drafts;
	public void drafts(Draft draft)
	{    this.drafts.add(draft);
	     if(draft.getTeam() != this) {
	        draft.setTeam(this);
	}}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Fan getFans() {
		return fans;
	}
	public void setFans(Fan fans) {
		this.fans = fans;
	}
	public Team(Draft website, int id, Fan fans, String description, 
			Date created, Date updated, int views) {
		super();
		this.id = id;
		this.fans = fans;
		this.title = title;
		this.description = description;
	}
	public Team(int id, String title, String description, 
			Date created, Date updated, int views) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	
}
