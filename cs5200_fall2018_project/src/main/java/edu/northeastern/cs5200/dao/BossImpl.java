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
import edu.northeastern.cs5200.model.Boss;
import edu.northeastern.cs5200.model.Fan;

public class BossImpl implements BossDao{
	Connection connect = Connect.getConnection();
	
	@Override
	public void createBoss(Boss boss) {
		String findAllDevelopersSql = "INSERT INTO person (dtype,id,dob,email,firstname,lastname,password,username,team_id,type) VALUES (?,?,?,?,?,?,?,?,?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setString(1, "boss");
			statement1.setInt(2, boss.getId());
			statement1.setDate(3, boss.getDob());
			statement1.setString(4, boss.getEmail());
			statement1.setString(5, boss.getFirstname());
			statement1.setString(6, boss.getLastname());
			statement1.setString(7, boss.getPassword());
			statement1.setString(8, boss.getUsername());
			statement1.setString(9, "boss");
			statement1.setInt(10, boss.getTeam().getId());
			
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}			
	}

	@Override
	public Collection<Boss> findAllBoss() {
		String findAllDevelopersSql = "SELECT * FROM person WHERE dtype = 'boss'";
		List<Boss> bosses = new ArrayList<Boss>();
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
				String teamId = results.getString("team_id");
				
				int teamID = Integer.parseInt(teamId);
				int id1 = Integer.parseInt(idS);
				Date dob1 = java.sql.Date.valueOf(dob);
				TeamImpl TIMPL = new TeamImpl();
				Boss boss = null;
				boss = new Boss(id1, Firstname, Lastname, 
						Username, Password, email, dob1,TIMPL.findTeamById(teamID));
				bosses.add(boss);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return bosses;
	}

	@Override
	public Boss findBossById(int id) {
		String findAllDevelopersSql = "SELECT * FROM person WHERE id = "+id;
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			
			results = statement.executeQuery(findAllDevelopersSql);
			Boss boss = new Boss();
			while(results.next()) {
				String idS = results.getString("id");
				String Firstname = results.getString("firstname");
				String Lastname = results.getString("lastname");
				String Username = results.getString("username");
				String Password = results.getString("password");
				String email = results.getString("email");
				String dob = results.getString("dob");
				String teamId = results.getString("team_id");
				
				int teamID = Integer.parseInt(teamId);
				int id1 = Integer.parseInt(idS);
				Date dob1 = java.sql.Date.valueOf(dob);
				TeamImpl TIMPL = new TeamImpl();
				boss = new Boss(id1, Firstname, Lastname, 
						Username, Password, email, dob1,TIMPL.findTeamById(teamID));
			}
			return boss;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
	}

	@Override
	public Boss findBossByCredentials(String username, int password) {
		String findAllDevelopersSql = "SELECT * FROM person WHERE "
				+ "username='"+username+"'and password='"+password+"'";
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			
			results = statement.executeQuery(findAllDevelopersSql);
			Boss boss = null;
			while(results.next()) {
				String idS = results.getString("id");
				String Firstname = results.getString("firstname");
				String Lastname = results.getString("lastname");
				String Username = results.getString("username");
				String Password = results.getString("password");
				String email = results.getString("email");
				String dob = results.getString("dob");
				String teamId = results.getString("team_id");
				
				int teamID = Integer.parseInt(teamId);
				int id1 = Integer.parseInt(idS);
				Date dob1 = java.sql.Date.valueOf(dob);
				TeamImpl TIMPL = new TeamImpl();
				boss = new Boss(id1, Firstname, Lastname, 
						Username, Password, email, dob1,TIMPL.findTeamById(teamID));
			}
			return boss;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateBossById(int id, Boss boss) {
		String findAllDevelopersSql = "UPDATE person SET dtype=?,"
				+ "dob=?,email=?,firstname=?,"
				+ "lastname=?,password=?,username=?,team_id=?,type=? WHERE id =?";
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setString(1, "boss");
			statement.setDate(2, boss.getDob());
			statement.setString(3, boss.getEmail());
			statement.setString(4, boss.getFirstname());
			statement.setString(5, boss.getLastname());
			statement.setString(6, boss.getPassword());
			statement.setString(7, boss.getUsername());
			statement.setInt(8, boss.getTeam().getId());
			statement.setString(9, "boss");
			statement.setInt(10, id);

			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return;			
	}

	@Override
	public void deleteBossById(int id) {
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
