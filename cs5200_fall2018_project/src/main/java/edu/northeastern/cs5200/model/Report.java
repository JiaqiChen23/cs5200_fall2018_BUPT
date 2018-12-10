package edu.northeastern.cs5200.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Report {
	@Id  
	@GeneratedValue
	   (strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne()
	private Boss boss;
	@ManyToOne()
	private Scout scout;
	private String reportbody;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boss getBoss() {
		return boss;
	}
	public void setBoss(Boss boss) {
		this.boss = boss;
	}
	public Scout getScout() {
		return scout;
	}
	public void setScout(Scout scout) {
		this.scout = scout;
	}
	public String getReportbody() {
		return reportbody;
	}
	public void setReportbody(String reportbody) {
		this.reportbody = reportbody;
	}
	public Report(int id, Boss boss, Scout scout, String reportbody)
		{
			super();
			this.id = id;
			this.boss = boss;
			this.scout = scout;
			this.reportbody = reportbody;
		}
	public Report() {
		super();
	}
}
