package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Fan> findAllFans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fan findFanById(int id) {
		String findAllDevelopersSql = "SELECT * FROM person WHERE id = ? and dtype = 'fan'"+id;
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
	public Fan findFanByCredentials(String username, int password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateFanById(int id, Fan fan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFanById(int id) {
		// TODO Auto-generated method stub
		
	}

}
