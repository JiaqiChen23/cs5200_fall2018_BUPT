package edu.northeastern.cs5200.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Boss extends Person{
//	@Id  
//	@GeneratedValue
//	   (strategy=GenerationType.IDENTITY)
//	private int id;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Report> getReportCollection() {
		return ReportCollection;
	}

	public void setReportCollection(List<Report> reportCollection) {
		ReportCollection = reportCollection;
	}
	public Boss(int id, String firstname, String lastname, 
			String username, String password, String email, Date dob,
			String name, Team team, List<Report> reportCollection)
	{
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.team = team;
		ReportCollection = reportCollection;
	}
}
