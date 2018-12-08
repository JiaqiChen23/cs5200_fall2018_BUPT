package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Stadium;

public interface StadiumDao {

	public void createStadium(Stadium stadium);
	
	public Collection<Stadium> findAllStadium();
	
	public Stadium findStadiumById(int id);
	
	public Stadium findStadiumByTeamId(int id);
	
	public void updateStadiumById(int id, Stadium stadium);
	
	public void deleteStadiumById(int id);
}
