package edu.northeastern.cs5200.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="team")
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private int sponsorAmount;
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, 
	        mappedBy = "team")
	private Sponsor spon;
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, 
	        mappedBy = "team")
	private Boss boss;
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, 
	        mappedBy = "team")
	private Stadium stadium;
	
	@OneToMany(mappedBy="team")
	private List<Draft> drafts;
	public void drafts(Draft draft)
	{    this.drafts.add(draft);
	     if(draft.getTeam() != this) {
	        draft.setTeam(this);
	}}
	
	@OneToMany(mappedBy="team")
	private List<Player> TeamPlayer;
	public void TeamPlayer(Player player)
	{    this.TeamPlayer.add(player);
	     if(player.getTeam() != this) {
	        player.setTeam(this);
	}}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Sponsor getSpon() {
		return spon;
	}

	public void setSpon(Sponsor spon) {
		this.spon = spon;
	}

	public Boss getBoss() {
		return boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	public int getSponsorAmount() {
		return sponsorAmount;
	}

	public void setSponsorAmount(int sponsorAmount) {
		this.sponsorAmount = sponsorAmount;
	}
	
	public List<Draft> getDrafts() {
		return drafts;
	}

	public void setDrafts(List<Draft> drafts) {
		this.drafts = drafts;
	}

	public List<Player> getTeamPlayer() {
		return TeamPlayer;
	}

	public void setTeamPlayer(List<Player> teamPlayer) {
		this.TeamPlayer = teamPlayer;
	}

	public Team(Draft website, int id, Fan fans, String title, String description, Sponsor spon,
			Boss boss, Stadium stadium, int sponsorAmount, 
			List<Draft> drafts, List<Player> teamPlayer) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.spon = spon;
		this.boss = boss;
		this.stadium = stadium;
		this.sponsorAmount = sponsorAmount;
		this.drafts = drafts;
		this.TeamPlayer = teamPlayer;
	}

}
