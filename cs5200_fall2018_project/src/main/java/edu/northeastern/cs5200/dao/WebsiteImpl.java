package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.Connect;
import edu.northeastern.cs5200.model.Fans;
import edu.northeastern.cs5200.model.Website;

public class WebsiteImpl implements WebsiteDao{

	Connection connect = Connect.getConnection();
	
	@Override
	public void createWebsiteForDeveloper(int developerId, Website website) {
		String findAllDevelopersSql = "INSERT INTO website (id,name,description,created,updated,visits,developer_id) VALUES (?,?,?,?,?,?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setInt(1, website.getId());
			statement1.setString(2, website.getName());
			statement1.setString(3, website.getDescription());
			statement1.setDate(4, website.getCreated());
			statement1.setDate(5, website.getUpdated());
			statement1.setInt(6, website.getVisits());
			statement1.setInt(7,developerId);
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	@Override
	public Collection<Website> findAllWebsites() {
		String findAllDevelopersSql = "SELECT * FROM website";
		List<Website> websites = new ArrayList<Website>();
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
				String Devid = results.getString("developer_id");
				String name = results.getString("name");
				String description = results.getString("description");
				String createdS = results.getString("created");
				String updatedS = results.getString("updated");
				String visitsS = results.getString("visits");
				int visits = Integer.parseInt(visitsS);
				int id = Integer.parseInt(idS);
				int developer_id = Integer.parseInt(Devid);
				Date created = java.sql.Date.valueOf(createdS);
				Date updated = java.sql.Date.valueOf(updatedS);
				DeveloperImpl devI = new DeveloperImpl();
				Website website = new Website(devI.findDeveloperById(developer_id),id,name,description,created,updated,visits);
				websites.add(website);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return websites;
	}		


	@Override
	public Collection<Website> findWebsitesForDeveloper(int developerId) {
		String findAllDevelopersSql = "SELECT * FROM website WHERE developer_id ="+developerId;
		List<Website> websites = new ArrayList<Website>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);

			while(results.next()) {
				String idS = results.getString("id");
				String Devid = results.getString("developer_id");
				String name = results.getString("name");
				String description = results.getString("description");
				String createdS = results.getString("created");
				String updatedS = results.getString("updated");
				String visitsS = results.getString("visits");
				int visits = Integer.parseInt(visitsS);
				int id = Integer.parseInt(idS);
				int developer_id = Integer.parseInt(Devid);
				Date created = java.sql.Date.valueOf(createdS);
				Date updated = java.sql.Date.valueOf(updatedS);
				DeveloperImpl devI = new DeveloperImpl();
				Website website = new Website(devI.findDeveloperById(developer_id),id,name,description,created,updated,visits);
				websites.add(website);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return websites;
	}

	@Override
	public Website findWebsiteById(int websiteId) {
		String findAllDevelopersSql = "SELECT * FROM website WHERE id = "+websiteId;
		Statement statement = null;
		ResultSet results = null;
		Website website = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			while(results.next()) {
				String idS = results.getString("id");
				String Devid = results.getString("developer_id");
				String name = results.getString("name");
				String description = results.getString("description");
				String createdS = results.getString("created");
				String updatedS = results.getString("updated");
				String visitsS = results.getString("visits");
				int visits = Integer.parseInt(visitsS);
				int id = Integer.parseInt(idS);
				int developer_id = Integer.parseInt(Devid);
				Date created = java.sql.Date.valueOf(createdS);
				Date updated = java.sql.Date.valueOf(updatedS);
				DeveloperImpl devI = new DeveloperImpl();
				website = new Website(devI.findDeveloperById(developer_id),id,name,description,created,updated,visits);
			}
			return website;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		
	}

	@Override
	public int updateWebsite(int websiteId, Website website) {
		String findAllDevelopersSql = "UPDATE website SET name =?, description =?, created =?, updated =?,"+
				"visits =?, developer_id=?  WHERE id =?";
		
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			statement.setDate(3, website.getCreated());
			statement.setDate(4, website.getUpdated());
			statement.setInt(5, website.getVisits());
			statement.setInt(6,website.getDeveloper().getId());
			statement.setInt(7, websiteId);
			statement.executeUpdate();
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteWebsite(int websiteId) {
		String findAllDevelopersSql = "DELETE FROM website WHERE id = ?";		
		try {
			PreparedStatement statement = connect.prepareStatement(findAllDevelopersSql);
			statement.setInt(1,websiteId);
			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}		return 0;
	}

}
