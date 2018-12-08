package edu.northeastern.cs5200.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Boss extends Person{
	@Id  
	@GeneratedValue
	   (strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private Team team;
	@OneToMany(mappedBy="boss")
	private List<Report> ReportCollection;
	public void ReportCollection(Report report)
	{    this.ReportCollection.add(report);
	     if(report.getBoss() != this) {
	        report.setBoss(this);
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
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
}