package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Draft;

public interface WebsiteDao {
	public void createWebsiteForDeveloper(int developerId, Draft website);
	public Collection<Draft> findAllWebsites();
	public Collection<Draft> findWebsitesForDeveloper(int developerId);
	public Draft findWebsiteById(int websiteId);
	public int updateWebsite(int websiteId, Draft website);
	int deleteWebsite(int websiteId);
	
}
