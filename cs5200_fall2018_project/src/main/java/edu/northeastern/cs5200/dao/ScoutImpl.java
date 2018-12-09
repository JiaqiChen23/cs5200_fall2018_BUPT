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
import edu.northeastern.cs5200.model.Fan;
import edu.northeastern.cs5200.model.Scout;

public class ScoutImpl implements ScoutDao{
	Connection connect = Connect.getConnection();

	@Override
	public void createScout(Scout scout) {
		String findAllDevelopersSql = "INSERT INTO person (dtype,id,dob,email,firstname,lastname,password,username,type) VALUES (?,?,?,?,?,?,?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setString(1, "scout");
			statement1.setInt(2, scout.getId());
			statement1.setDate(3, scout.getDob());
			statement1.setString(4, scout.getEmail());
			statement1.setString(5, scout.getFirstname());
			statement1.setString(6, scout.getLastname());
			statement1.setString(7, scout.getPassword());
			statement1.setString(8, scout.getUsername());
			statement1.setString(9, "scout");
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}		
	}

	@Override
	public Collection<Scout> findAllScouts() {
		String findAllDevelopersSql = "SELECT * FROM person WHERE dtype = 'fan'";
		List<Scout> scouts = new ArrayList<Scout>();
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
				Scout scout = new Scout();
				scout = new Scout(id1, Firstname, Lastname, 
						Username, Password, email, dob1);
				scouts.add(scout);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return scouts;
	}

	@Override
	public Scout findScoutById(int id) {
		String findAllDevelopersSql = "SELECT * FROM person WHERE dtype = 'scout' AND id = "+id;
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			
			results = statement.executeQuery(findAllDevelopersSql);
			Scout scout = new Scout();
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
				scout = new Scout(id1, Firstname, Lastname, 
						Username, Password, email, dob1);
			}
			return scout;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
	}

	@Override
	public Scout findScoutByCredentials(String username, int password) {
		String findAllDevelopersSql = "SELECT * FROM person WHERE "
				+ "username='"+username+"'and password='"+password+"'";
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			
			results = statement.executeQuery(findAllDevelopersSql);
			Scout scout = null;
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
				scout = new Scout(id1, Firstname, Lastname, 
						Username, Password, email, dob1);
			}
			return scout;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateScoutById(int id, Scout scout) {
		String findAllDevelopersSql = "UPDATE person SET dtype=?,"
				+ "dob=?,email=?,firstname=?,"
				+ "lastname=?,password=?,username=?,type=?  WHERE id =?";
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setString(1, "scout");
			statement.setDate(2, scout.getDob());
			statement.setString(3, scout.getEmail());
			statement.setString(4, scout.getFirstname());
			statement.setString(5, scout.getLastname());
			statement.setString(6, scout.getPassword());
			statement.setString(7, scout.getUsername());
			statement.setString(8, "scout");
			statement.setInt(9, id);

			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return;	
	}

	@Override
	public void deleteScoutById(int id) {
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
