package edu.northeastern.cs5200.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="page")
public class Page {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private Date created;
	private Date updated;
	private int views;
	@ManyToOne()
	@JsonIgnore
	private Website website;
	
	@OneToMany(mappedBy="page")
	private List<Widget> containWidget;
	public void containWidget(Widget wid)
	{    this.containWidget.add(wid);
	     if(wid.getPage() != this) {
	        wid.setPage(this);
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
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Website getWebsite() {
		return website;
	}
	public void setWebsite(Website website) {
		if(!website.getContainPage().contains(this))
			website.getContainPage().add(this);
	}

	public List<Widget> getContainWidget() {
		return containWidget;
	}

	public void setContainWidget(List<Widget> containWidget) {
		this.containWidget = containWidget;
	}
	public Page(Website website, int id, String title, String description, 
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
	public Page(int id, String title, String description, 
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
