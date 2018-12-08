package edu.northeastern.cs5200.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Player {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	

	
	
	
	public Player(int id, String name, int width, int height, String cssclass, String cssstyle,
			String text, int ordernum, Team page)
	{
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssclass = cssclass;
		this.cssstyle = cssstyle;
		this.text = text;
		this.ordernum = ordernum;
		this.page = page;
	}
		
		 
}
