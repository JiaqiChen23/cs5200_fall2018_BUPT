package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Fan;

public interface DeveloperDao {
	public void createDeveloper(Fan developer);
	public  Collection<Fan> findAllDevelopers();
	public Fan findDeveloperById(int developerId);
	public Fan findDeveloperByUsername(String username);
	public Fan findDeveloperByCredentials(String username, String password);
	public int updateDeveloper(int developerId, Fan developer);
	public int deleteDeveloper(int developerId);
}
