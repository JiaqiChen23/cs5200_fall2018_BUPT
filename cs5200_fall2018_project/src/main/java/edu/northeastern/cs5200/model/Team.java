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
	private Fans fans;
	
	
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

	public void setWebsite(Website website) {
		if(!website.getContainPage().contains(this))
			website.getContainPage().add(this);
	}


	public Team(Website website, int id, String title, String description, 
			Date created, Date updated, int views) {
		super();
		this.id = id;
		this.website = website;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
	}
	public Team(int id, String title, String description, 
			Date created, Date updated, int views) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
	}
	
}
