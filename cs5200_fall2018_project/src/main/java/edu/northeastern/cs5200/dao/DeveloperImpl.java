package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.Connect;
import edu.northeastern.cs5200.model.Fans;

public class DeveloperImpl implements DeveloperDao {
	Connection connect = Connect.getConnection();

	@Override
	public void createDeveloper(Fans developer) {
		String findAllDevelopersSql = "INSERT INTO person (firstname,lastname,username,password,email,dob,id) VALUES (?,?,?,?,?,?,?);";
		String forDev = "INSERT INTO developer (id, developerkey) VALUES (?,?);";
		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setString(1, developer.getFirstname());
			statement1.setString(2, developer.getLastname());
			statement1.setString(3, developer.getUsername());
			statement1.setString(4, developer.getPassword());
			statement1.setString(5, developer.getEmail());
			statement1.setDate(6, developer.getDob());
			statement1.setInt(7, developer.getId());
			statement1.executeUpdate();
			statement1 = connect.prepareStatement(forDev);
			
			statement1.setInt(1, developer.getId());
			statement1.setString(2, developer.getDeveloperKey());
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	@Override
	public Collection<Fans> findAllDevelopers() {
		String findAllDevelopersSql = "SELECT * FROM person, developer WHERE person.id = developer.id";
		List<Fans> developers = new ArrayList<Fans>();
						Statement statement = null;
						ResultSet results = null;
						try {
							statement = connect.createStatement();
							results = statement.executeQuery(findAllDevelopersSql);
							while(results.next()) {
								String idS = results.getString("id");
								String firstname = results.getString("firstname");
								String lastname = results.getString("lastname");
								String username = results.getString("username");
								String password = results.getString("password");
								String email = results.getString("email");
								String date = results.getString("dob");
								String key = results.getString("developerKey");
								int id = Integer.parseInt(idS);
								Date dob = java.sql.Date.valueOf(date);
								Fans developer = new Fans(id, firstname, lastname, username, password, email, dob, key);
								developers.add(developer);
							}
						
} catch (SQLException e) {
	e.printStackTrace();
}
return developers;
	}

	@Override
	public Fans findDeveloperById(int developerId) {
		String findAllDevelopersSql = "SELECT * FROM Fans WHERE id = "+developerId;
		Statement statement = null;
		ResultSet results = null;
		Fans developer = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			while(results.next()) {
				String idS = results.getString("id");
				String firstname = results.getString("firstname");
				String lastname = results.getString("lastname");
				String username = results.getString("username");
				String password = results.getString("password");
				String email = results.getString("email");
				String date = results.getString("dob");
				String key = results.getString("developerKey");
				int id = Integer.parseInt(idS);
				Date dob = java.sql.Date.valueOf(date);
				developer = new Fans(id, firstname, lastname, username, password, email, dob, key);			
			}
			return developer;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
	}


	@Override
	public Fans findDeveloperByUsername(String username) {
		String findAllDevelopersSql = "SELECT * FROM person WHERE username = "+username;
		Statement statement = null;
		ResultSet results = null;
		
		try {
			statement = connect.createStatement();
			
			results = statement.executeQuery(findAllDevelopersSql);
			String idS = results.getString("id");
			String firstname = results.getString("firstname");
			String lastname = results.getString("lastname");
			String usernameL = results.getString("username");
			String password = results.getString("password");
			String email = results.getString("email");
			String date = results.getString("dob");
			int id = Integer.parseInt(idS);
			String key = results.getString("developerKey");
			Date dob = java.sql.Date.valueOf(date);
			Fans developer = new Fans(id, firstname, lastname, usernameL, password, email, dob, key);
			return developer;
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return null;
		}	}

	@Override
	public Fans findDeveloperByCredentials(String username, String password) {
		// TODO Auto-generated method stub
		String findAllDevelopersSql = "SELECT * FROM person WHERE username = "+username+"AND password = "+password;
		Statement statement = null;
		ResultSet results = null;
		
		try {
			statement = connect.createStatement();
			
			results = statement.executeQuery(findAllDevelopersSql);
			String idS = results.getString("id");
			String firstname = results.getString("firstname");
			String lastname = results.getString("lastname");
			String usernameL = results.getString("username");
			String passwordL = results.getString("password");
			String email = results.getString("email");
			String date = results.getString("dob");
			int id = Integer.parseInt(idS);
			String key = results.getString("developerKey");
			Date dob = java.sql.Date.valueOf(date);
			Fans developer = new Fans(id, firstname, lastname, usernameL, passwordL, email, dob, key);
			return developer;
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateDeveloper(int developerId, Fans developer) {
		// TODO Auto-generated method stub
		
		String findAllDevelopersSql = "UPDATE person SET firstname =?, lastname =?, username =?, password =?,"+
				"email =?, dob =?  WHERE id =?";
		
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setString(1, developer.getFirstname());
			statement.setString(2, developer.getLastname());
			statement.setString(3, developer.getUsername());
			statement.setString(4, developer.getPassword());
			statement.setString(5, developer.getEmail());
			statement.setDate(6, developer.getDob());
			statement.setInt(7, developerId);
			
			statement.executeUpdate();
		String forDev = "UPDATE developer SET developerkey = ? WHERE id = ?";
		statement = connect.prepareStatement(forDev);
		statement.setString(1, developer.getDeveloperKey());
		statement.setInt(2, developerId);
		statement.executeUpdate()
;		
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteDeveloper(int developerId) {
		// TODO Auto-generated method stub
		String findAllDevelopersSql = "DELETE FROM person WHERE id = ?";		
		try {
			PreparedStatement statement = connect.prepareStatement(findAllDevelopersSql);
			statement.setInt(1,developerId);
			statement.executeUpdate();
			String forDev = "DELETE FROM developer WHERE id = ?";
			statement = connect.prepareStatement(forDev);
			statement.setInt(1,developerId);
			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return 0;
	}
}
