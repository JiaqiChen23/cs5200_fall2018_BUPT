package edu.northeastern.cs5200.model;
 import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
 import com.fasterxml.jackson.annotation.JsonIgnore;
 @Entity
public class Allstar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	
	@ManyToOne()
	@JsonIgnore
	private Fan fans;
	
	@ManyToOne()
	private Player player;
	
 	public int getId() {
		return id;
	}
 	public void setId(int id) {
		this.id = id;
	}

	public Fan getFans() {
		return fans;
	}

	public void setFans(Fan fans) {
		this.fans = fans;
	}
	
 	public Fan getFan() {
		return fans;
	}
 	
 	public void setFan(Fan fan) {
		this.fans = fan;

 	}
 	public Player getPlayer() {
		return player;
	}
 	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Allstar(int id, Fan fans, Player player)
	{
		this.id = id;
		this.fans = fans;
		this.player = player;
	}
	public Allstar() {
		super();
	}
}