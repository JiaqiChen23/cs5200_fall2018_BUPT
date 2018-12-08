package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Fans;

public interface DeveloperDao {
	public void createDeveloper(Fans developer);
	public  Collection<Fans> findAllDevelopers();
	public Fans findDeveloperById(int developerId);
	public Fans findDeveloperByUsername(String username);
	public Fans findDeveloperByCredentials(String username, String password);
	public int updateDeveloper(int developerId, Fans developer);
	public int deleteDeveloper(int developerId);
}
