package edu.northeastern.cs5200.model;

import javax.persistence.*;

@Entity
public class sponsor extends person{
	@Id  
	@GeneratedValue
	   (strategy=GenerationType.IDENTITY)
	private int id;
	private String sponsored;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSponsored() {
		return sponsored;
	}
	public void setSponsored(String sponsored) {
		this.sponsored = sponsored;
	}


	
}
