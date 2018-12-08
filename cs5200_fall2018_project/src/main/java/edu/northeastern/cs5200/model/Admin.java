package edu.northeastern.cs5200.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Admin extends Person{
	@Id  
	@GeneratedValue
	private int id;
}
