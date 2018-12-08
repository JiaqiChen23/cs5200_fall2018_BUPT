package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Scout;

public interface ScoutDao {

	public void createScout(Scout scout);
	
	public Collection<Scout> findAllScouts();
	
	public Scout findScoutById(int id);
	
	public Scout findScoutByCredentials(String username, int password);
	
	public void updateScoutById(int id, Scout scout);
	
	public void deleteScoutById(int id);
}
