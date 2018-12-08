package edu.northeastern.cs5200.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Scout extends Person{

	@Id  
	@GeneratedValue
	   (strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy="scout")
	private List<Report> ReportCollection;
	public void ReportCollection(Report report)
	{    this.ReportCollection.add(report);
	     if(report.getScout() != this) {
	        report.setScout(this);
	}}
	
	
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
	
}
