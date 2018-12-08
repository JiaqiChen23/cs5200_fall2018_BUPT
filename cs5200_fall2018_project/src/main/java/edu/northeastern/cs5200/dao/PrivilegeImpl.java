package edu.northeastern.cs5200.dao;

import java.sql.*;

import edu.northeastern.cs5200.Connect;

public class PrivilegeImpl{
	public static PrivilegeImpl instance = null;
	public static PrivilegeImpl getInstance(){
		if(instance == null){
			instance = new PrivilegeImpl();
		}
		return instance;
	}
	Connection connect = Connect.getConnection();

	
	public int assignWebsitePriviledge(int developerId, int websiteId, int priviledgeId){
        int rs = 0;
        try{
            
			String query = "INSERT INTO priviledge (developerId, websiteId, priviledge), VALUES(?,?,?)";
			PreparedStatement statement = 
    				connect.prepareStatement(query);
			statement.setInt(1, developerId);
			statement.setInt(2, websiteId);
            statement.setInt(3, priviledgeId);
			rs = statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	public int assignPagePriviledge(int developerId, int pageId, int priviledgeId) {
        int rs = 0;
        try{
			String query = "INSERT INTO priviledge (developerId, pageId, priviledge), VALUES(?,?,?)";
			PreparedStatement statement = 
    				connect.prepareStatement(query);
			statement.setInt(1, developerId);
			statement.setInt(2, pageId);
			statement.setInt(3, priviledgeId);
			rs = statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	public int deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId){
        int rs = 0;
        try{
            
			String query = "DELETE FROM priviledge where developerId = ? AND websiteId = ? AND priviledge = ?";
			PreparedStatement statement = 
    				connect.prepareStatement(query);
			statement.setInt(1, developerId);
			statement.setInt(2, websiteId);
            statement.setInt(3, priviledgeId);
			rs = statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	public int deletePagePriviledge(int developerId, int pageId, int priviledgeId){
        int rs = 0;
        try{
            
			String query = "DELETE FROM priviledge where developerId = ? AND pageId = ? AND priviledge = ?";
			PreparedStatement statement = 
    				connect.prepareStatement(query);
			statement.setInt(1, developerId);
			statement.setInt(2, pageId);
            statement.setInt(3, priviledgeId);
			rs = statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
}
