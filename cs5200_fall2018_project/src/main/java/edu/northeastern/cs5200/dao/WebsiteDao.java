package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Website;

public interface WebsiteDao {
	public void createWebsiteForDeveloper(int developerId, Website website);
	public Collection<Website> findAllWebsites();
	public Collection<Website> findWebsitesForDeveloper(int developerId);
	public Website findWebsiteById(int websiteId);
	public int updateWebsite(int websiteId, Website website);
	int deleteWebsite(int websiteId);
	
}
