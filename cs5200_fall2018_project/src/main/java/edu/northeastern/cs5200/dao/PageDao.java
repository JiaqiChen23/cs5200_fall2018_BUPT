package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Team;

public interface PageDao {
	public void createPageForWebsite(int websiteId, Team page);
	public Collection<Team> findAllPages();
	public Team findPageById(int pageId);
	public Collection<Team> findPagesForWebsite(int websiteId);
	public int updatePage(int pageId, Team page);
	public int deletePage(int pageId);
}
