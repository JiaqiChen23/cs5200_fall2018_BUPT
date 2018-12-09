package edu.northeastern.cs5200.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Scout extends Person{

//	@Id  
//	@GeneratedValue
//	   (strategy=GenerationType.IDENTITY)
//	private int id;
	
	@OneToMany(mappedBy="scout")
	private List<Report> ReportCollection;
	public void ReportCollection(Report report)
	{    this.ReportCollection.add(report);
	     if(report.getScout() != this) {
	        report.setScout(this);
	}}
	
	
	public List<Report> getReportCollection() {
		return ReportCollection;
	}


	public void setReportCollection(List<Report> reportCollection) {
		ReportCollection = reportCollection;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Scout(int id, String firstname, String lastname, 
			String username, String password, String email, Date dob,
			List<Report> reportCollection) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		ReportCollection = reportCollection;
	}
}
