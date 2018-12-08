package edu.northeastern.cs5200.dao;

public interface PrivilegeDao {
	public void assignWebsitePriviledge(int developerId, int websiteId, String priviledge);
	public void assignPagePriviledge(int developerId, int pageId, String priviledge);
	public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge);
	public void deletePagePriviledge(int developerId, int pageId, String priviledge);
}
