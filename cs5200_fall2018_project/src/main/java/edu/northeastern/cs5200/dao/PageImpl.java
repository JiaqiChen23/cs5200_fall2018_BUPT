package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.Connect;
import edu.northeastern.cs5200.model.Team;
import edu.northeastern.cs5200.model.Draft;

public class PageImpl implements PageDao{
	Connection connect = Connect.getConnection();

	@Override
	public void createPageForWebsite(int websiteId, Team page) {
		String findAllDevelopersSql = "INSERT INTO page (id,title,description,created,updated,views,website_id) VALUES (?,?,?,?,?,?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setInt(1, page.getId());
			statement1.setString(2, page.getTitle());
			statement1.setString(3, page.getDescription());
			statement1.setDate(4, page.getCreated());
			statement1.setDate(5, page.getUpdated());
			statement1.setInt(6, page.getViews());
			statement1.setInt(7,websiteId);
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}		
	}

	@Override
	public Collection<Team> findAllPages() {
		String findAllDevelopersSql = "SELECT * FROM page";
		List<Team> pages = new ArrayList<Team>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
//			ResultSetMetaData rsmd = results.getMetaData();
//			int columnsNumber = rsmd.getColumnCount();
//			while (results.next()) {
//			    for (int i = 1; i <= columnsNumber; i++) {
//			        if (i > 1) System.out.print(",  ");
//			        String columnValue = results.getString(i);
//			        System.out.print(columnValue + " " + rsmd.getColumnName(i));
//			    }
//			    System.out.println("");
//			}

			while(results.next()) {
				String idS = results.getString("id");
				String WebId = results.getString("website_id");
				String title = results.getString("title");
				String description = results.getString("description");
				String createdS = results.getString("created");
				String updatedS = results.getString("updated");
				String viewsS = results.getString("views");
				int views = Integer.parseInt(viewsS);
				int id = Integer.parseInt(idS);
				int website_id = Integer.parseInt(WebId);
				Date created = java.sql.Date.valueOf(createdS);
				Date updated = java.sql.Date.valueOf(updatedS);
				WebsiteImpl webI = new WebsiteImpl();
				Team page = new Team(webI.findWebsiteById(website_id),id,title,description,created,updated,views);
				pages.add(page);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return pages;
	}

	@Override
	public Team findPageById(int pageId) {
		String findAllDevelopersSql = "SELECT * FROM page WHERE id = "+pageId;
		Statement statement = null;
		ResultSet results = null;
		Team page = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			while(results.next()) {
				String idS = results.getString("id");
				String WebId = results.getString("website_id");
				String title = results.getString("title");
				String description = results.getString("description");
				String createdS = results.getString("created");
				String updatedS = results.getString("updated");
				String viewsS = results.getString("views");
				int views = Integer.parseInt(viewsS);
				int id = Integer.parseInt(idS);
				int website_id = Integer.parseInt(WebId);
				Date created = java.sql.Date.valueOf(createdS);
				Date updated = java.sql.Date.valueOf(updatedS);
				WebsiteImpl webI = new WebsiteImpl();
				page = new Team(webI.findWebsiteById(website_id),id,title,description,created,updated,views);
			}
			return page;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
	}

	@Override
	public Collection<Team> findPagesForWebsite(int websiteId) {
		String findAllDevelopersSql = "SELECT * FROM page WHERE website_id ="+websiteId;
		List<Team> pages = new ArrayList<Team>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);

			while(results.next()) {
				String idS = results.getString("id");
				String WebId = results.getString("website_id");
				String title = results.getString("title");
				String description = results.getString("description");
				String createdS = results.getString("created");
				String updatedS = results.getString("updated");
				String viewsS = results.getString("views");
				int views = Integer.parseInt(viewsS);
				int id = Integer.parseInt(idS);
				int website_id = Integer.parseInt(WebId);
				Date created = java.sql.Date.valueOf(createdS);
				Date updated = java.sql.Date.valueOf(updatedS);
				WebsiteImpl webI = new WebsiteImpl();
				Team page = new Team(webI.findWebsiteById(website_id),id,title,description,created,updated,views);
				pages.add(page);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return pages;
	}

	@Override
	public int updatePage(int pageId, Team page) {
		String findAllDevelopersSql = "UPDATE page SET title =?, description =?, created =?, updated =?,"+
				"views =?, website_id=?  WHERE id =?";
		
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setString(1, page.getTitle());
			statement.setString(2, page.getDescription());
			statement.setDate(3, page.getCreated());
			statement.setDate(4, page.getUpdated());
			statement.setInt(5, page.getViews());
			statement.setInt(6,page.getWebsite().getId());
			statement.setInt(7, page.getId());

			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deletePage(int pageId) {
		String findAllDevelopersSql = "DELETE FROM page WHERE id = ?";		
		try {
			PreparedStatement statement = connect.prepareStatement(findAllDevelopersSql);
			statement.setInt(1,pageId);
			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}		return 0;
	}
}

