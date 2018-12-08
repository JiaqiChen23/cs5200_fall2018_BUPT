package edu.northeastern.cs5200.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Website {
	@ManyToOne()
	@JsonIgnore
	private Developer developer;
	@Id  
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private int visits;
	
	@OneToMany(mappedBy="website")
	private List<Page> containPage;
	public void containPage(Page page)
	{    this.containPage.add(page);
	     if(page.getWebsite() != this) {
	        page.setWebsite(this);
	}}
	
	public List<Page> getContainPage() {
		return containPage;
	}

	public void setContainPage(List<Page> containPage) {
		this.containPage = containPage;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Developer getDeveloper() {
		return developer;
	}
	public void setDeveloper(Developer developer) {
		if(!developer.getImplementWeb().contains(this))
			developer.getImplementWeb().add(this);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String escription) {
		this.description = escription;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	public Website(Developer developer, int id, String name, String description, 
			Date created, Date updated, int visits) {
		super();
		this.id = id;
		this.developer = developer;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
	}
	public Website(int id, String name, String description, Date created, Date updated, int visits) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
	}
}
