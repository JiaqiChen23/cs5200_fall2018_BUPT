package edu.northeastern.cs5200.dao;

import java.sql.*;

import edu.northeastern.cs5200.Connect;

public class RoleImpl{
	Connection connect = Connect.getConnection();

	public static RoleImpl instance = null;
	public static RoleImpl getInstance(){
		if(instance == null){
			instance = new RoleImpl();
		}
		return instance;
	}
	
	public int assignWebsiteRole(int developerId, int websiteId, int roleId){
        int rs = 0;
        try{
        	
			String query = "INSERT INTO role (developerId, websiteId, Role) VALUES(?,?,?)";
			PreparedStatement statement = 
    				connect.prepareStatement(query);
			statement.setInt(1, developerId);
			statement.setInt(2, websiteId);
            statement.setInt(3, roleId);
			rs = statement.executeUpdate();
        }catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public int assignPageRole(int developerId, int pageId, int roleId){
        int rs = 0;
        try{
            
			String query = "INSERT INTO role (developerId, pageId, Role) VALUES(?,?,?)";
			PreparedStatement statement = 
    				connect.prepareStatement(query);
			statement.setInt(1, developerId);
			statement.setInt(2, pageId);
            statement.setInt(3, roleId);
			rs = statement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
		}
		return rs;
	}
	
	public int deleteWebsiteRole(int developerId, int websiteId, int roleId){
        int rs = 0;
        try{
            
			String query = "DELETE FROM role where developerId = ? AND websiteId = ? AND Role = ?";
			PreparedStatement statement = 
    				connect.prepareStatement(query);
			statement.setInt(1, developerId);
			statement.setInt(2, websiteId);
			statement.setInt(3, roleId);
            rs = statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int deletePageRole(int developerId, int pageId, int roleId){
        int rs = 0;
        try{
            
			String query = "DELETE FROM role where developerId = ? AND pageId = ? AND Role = ?";
			PreparedStatement statement = 
    				connect.prepareStatement(query);
			statement.setInt(1, developerId);
			statement.setInt(2, pageId);
			statement.setInt(3, roleId);
			rs = statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	public int swapPageRole(int dev1Id, int dev2Id, int pageId){
        int rs = 0;
        try{
            
			String query =  "UPDATE role SET `developerId` = " + 
							"CASE " + 
							"	WHEN `role`.developerId = ? THEN ?  " + 
							"	WHEN `role`.developerId = ? THEN ?  " + 
							"	ELSE `role`.developerId  " + 
							"END WHERE pageId = ?;";
			PreparedStatement statement = 
    				connect.prepareStatement(query);
            statement.setInt(1, dev1Id);
            statement.setInt(2, dev2Id);
            statement.setInt(3, dev2Id);
            statement.setInt(4, dev1Id);
            statement.setInt(5, pageId);
            rs = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return rs;
	}

}
