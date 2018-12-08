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
	private Fan fan;
	
	@ManyToOne()
	@JsonIgnore
	private Player player;
 	public int getId() {
		return id;
	}
 	public void setId(int id) {
		this.id = id;
	}
 	public Fan getFan() {
		return fan;
	}
 	public void setFan(Fan fan) {
		this.fan = fan;
	}
 	public Player getPlayer() {
		return player;
	}
 	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Allstar(int id, Fan fan, Player player)
	{
		this.id = id;
		this.fan = fan;
		this.player = player;
	}
}