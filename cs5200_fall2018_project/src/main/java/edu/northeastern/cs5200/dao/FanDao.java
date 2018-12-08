package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Fan;

public interface FanDao {

	public void createFan(Fan fan);
	
	public Collection<Fan> findAllFans();
	
	public Fan findFanById(int id);
	
	public Fan findFanByCredentials(String username, int password);
	
	public void updateFanById(int id, Fan fan);
	
	public void deleteFanById(int id);
}
