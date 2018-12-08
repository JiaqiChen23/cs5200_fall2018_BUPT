package edu.northeastern.cs5200.model;

import javax.persistence.*;

@Entity
public class user extends person{
	@Id  
	@GeneratedValue
	   (strategy=GenerationType.IDENTITY)
	private int id;
	private boolean useragreement;

	public boolean isUseragreement() {
		return useragreement;
	}
	public void setUseragreement(boolean useragreement) {
		this.useragreement = useragreement;
	}
	
}
