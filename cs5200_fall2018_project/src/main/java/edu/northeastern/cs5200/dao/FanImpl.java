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
import edu.northeastern.cs5200.model.Allstar;
import edu.northeastern.cs5200.model.Fan;
import edu.northeastern.cs5200.model.Player;

public class FanImpl implements FanDao{
	Connection connect = Connect.getConnection();
	
	@Override
	public void createFan(Fan fan) {
		String findAllDevelopersSql = "INSERT INTO person (dtype,id,dob,email,firstname,lastname,password,username,type) VALUES (?,?,?,?,?,?,?,?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setString(1, "fan");
			statement1.setInt(2, fan.getId());
			statement1.setDate(3, fan.getDob());
			statement1.setString(4, fan.getEmail());
			statement1.setString(5, fan.getFirstname());
			statement1.setString(6, fan.getLastname());
			statement1.setString(7, fan.getPassword());
			statement1.setString(8, fan.getUsername());
			statement1.setString(9, "fan");
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}	
	}

	@Override
	public Collection<Fan> findAllFans() {
		String findAllDevelopersSql = "SELECT * FROM person WHERE dtype = 'fan'";
		List<Fan> fans = new ArrayList<Fan>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String Firstname = results.getString("firstname");
				String Lastname = results.getString("lastname");
				String Username = results.getString("username");
				String Password = results.getString("password");
				String email = results.getString("email");
				String dob = results.getString("dob");
				
				int id1 = Integer.parseInt(idS);
				Date dob1 = java.sql.Date.valueOf(dob);
				Fan fan = new Fan();
				fan = new Fan(id1, Firstname, Lastname, 
						Username, Password, email, dob1);
				fans.add(fan);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return fans;
	}

	@Override
	public Fan findFanById(int id) {
		String findAllDevelopersSql = "SELECT * FROM person WHERE id = "+id;
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			
			results = statement.executeQuery(findAllDevelopersSql);
			Fan fan = new Fan();
			while(results.next()) {
				String idS = results.getString("id");
				String Firstname = results.getString("firstname");
				String Lastname = results.getString("lastname");
				String Username = results.getString("username");
				String Password = results.getString("password");
				String email = results.getString("email");
				String dob = results.getString("dob");
				
				int id1 = Integer.parseInt(idS);
				Date dob1 = java.sql.Date.valueOf(dob);
				fan = new Fan(id1, Firstname, Lastname, 
						Username, Password, email, dob1);
			}
			return fan;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
	}

	@Override
	public Fan findFanByCredentials(String username, int password) {
		String findAllDevelopersSql = "SELECT * FROM person WHERE "
				+ "username='"+username+"'and password='"+password+"'";
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			
			results = statement.executeQuery(findAllDevelopersSql);
			Fan fan = null;
			while(results.next()) {
				String idS = results.getString("id");
				String Firstname = results.getString("firstname");
				String Lastname = results.getString("lastname");
				String Username = results.getString("username");
				String Password = results.getString("password");
				String email = results.getString("email");
				String dob = results.getString("dob");
				
				int id1 = Integer.parseInt(idS);
				Date dob1 = java.sql.Date.valueOf(dob);
				fan = new Fan(id1, Firstname, Lastname, 
						Username, Password, email, dob1);
			}
			return fan;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
		}

	@Override
	public void updateFanById(int id, Fan fan) {
		String findAllDevelopersSql = "UPDATE person SET dtype=?,"
				+ "dob=?,email=?,firstname=?,"
				+ "lastname=?,password=?,username=?,type=?  WHERE id =?";
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setString(1, "fan");
			statement.setDate(2, fan.getDob());
			statement.setString(3, fan.getEmail());
			statement.setString(4, fan.getFirstname());
			statement.setString(5, fan.getLastname());
			statement.setString(6, fan.getPassword());
			statement.setString(7, fan.getUsername());
			statement.setString(8, "fan");
			statement.setInt(9, id);

			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return;		
	}

	@Override
	public void deleteFanById(int id) {
		String findAllDevelopersSql = "DELETE FROM person WHERE id = ?";		
		try {
			PreparedStatement statement = connect.prepareStatement(findAllDevelopersSql);
			statement.setInt(1,id);
			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}		return;
	}		

}
