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
import edu.northeastern.cs5200.model.Sponsor;

public class SponsorImpl implements SponsorDao{
	Connection connect = Connect.getConnection();
	@Override
	public void createSponsor(Sponsor sponsor) {
		String findAllDevelopersSql = "INSERT INTO person (dtype,id,dob,email,firstname,"
				+ "lastname,password,username,team_id,type=?) VALUES (?,?,?,?,?,?,?,?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setString(1, "sponsor");
			statement1.setInt(2, sponsor.getId());
			statement1.setDate(3, sponsor.getDob());
			statement1.setString(4, sponsor.getEmail());
			statement1.setString(5, sponsor.getFirstname());
			statement1.setString(6, sponsor.getLastname());
			statement1.setString(7, sponsor.getPassword());
			statement1.setString(8, sponsor.getUsername());
			statement1.setInt(9, sponsor.getTeam().getId());
			statement1.setString(10, "scout");
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}	
	}

	@Override
	public Collection<Sponsor> findAllSponsors() {
		String findAllDevelopersSql = "SELECT * FROM person WHERE dtype = 'sponsor'";
		List<Sponsor> sponsors = new ArrayList<Sponsor>();
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
				
				int id1 = Integer.parseInt(idS);
				Date dob1 = java.sql.Date.valueOf(dob);
				int teamID = Integer.parseInt(teamId);
				Sponsor sponsor = new Sponsor();
				TeamImpl TIMPL = new TeamImpl();
				sponsor = new Sponsor(id1, Firstname, Lastname, 
						Username, Password, email, dob1, TIMPL.findTeamById(teamID));
				sponsors.add(sponsor);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return sponsors;
	}

	@Override
	public Sponsor findSponsorById(int id) {
		String findAllDevelopersSql = "SELECT * FROM person WHERE id = "+id;
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			
			results = statement.executeQuery(findAllDevelopersSql);
			Sponsor sponsor = new Sponsor();
			while(results.next()) {
				String idS = results.getString("id");
				String Firstname = results.getString("firstname");
				String Lastname = results.getString("lastname");
				String Username = results.getString("username");
				String Password = results.getString("password");
				String email = results.getString("email");
				String dob = results.getString("dob");
				String teamID = results.getString("team_id");
				
				int id1 = Integer.parseInt(idS);
				Date dob1 = java.sql.Date.valueOf(dob);
				int Tid = Integer.parseInt(teamID);
				TeamImpl TIMPL = new TeamImpl();
				sponsor = new Sponsor(id1, Firstname, Lastname, 
						Username, Password, email, dob1,TIMPL.findTeamById(Tid));
			}
			return sponsor;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
	}

	@Override
	public Sponsor findSponsorByCredentials(String username, int password) {
		String findAllDevelopersSql = "SELECT * FROM person WHERE "
				+ "username='"+username+"'and password='"+password+"'";
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			
			results = statement.executeQuery(findAllDevelopersSql);
			Sponsor sponsor = null;
			while(results.next()) {
				String idS = results.getString("id");
				String Firstname = results.getString("firstname");
				String Lastname = results.getString("lastname");
				String Username = results.getString("username");
				String Password = results.getString("password");
				String email = results.getString("email");
				String dob = results.getString("dob");
				String teamID = results.getString("team_id");
				
				int id1 = Integer.parseInt(idS);
				Date dob1 = java.sql.Date.valueOf(dob);
				int Tid = Integer.parseInt(teamID);
				TeamImpl TIMPL = new TeamImpl();
				sponsor = new Sponsor(id1, Firstname, Lastname, 
						Username, Password, email, dob1,TIMPL.findTeamById(Tid));
			}
			return sponsor;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateSponsorById(int id, Sponsor sponsor) {
		String findAllDevelopersSql = "UPDATE person SET dtype=?,"
				+ "dob=?,email=?,firstname=?,"
				+ "lastname=?,password=?,username=?,team_id=?,type=?  WHERE id =?";
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setString(1, "sponsor");
			statement.setDate(2, sponsor.getDob());
			statement.setString(3, sponsor.getEmail());
			statement.setString(4, sponsor.getFirstname());
			statement.setString(5, sponsor.getLastname());
			statement.setString(6, sponsor.getPassword());
			statement.setString(7, sponsor.getUsername());
			statement.setInt(8, sponsor.getTeam().getId());
			statement.setString(9, "scout");
			statement.setInt(10, id);

			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return;	
		
	}

	@Override
	public void deleteSponsorById(int id) {
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

	@Override
	public Sponsor findSponsorByTeamId(int id) {
		String findAllDevelopersSql = "SELECT * FROM person WHERE dtype=sponsor AND team_id="+id;
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			
			results = statement.executeQuery(findAllDevelopersSql);
			Sponsor sponsor = new Sponsor();
			while(results.next()) {
				String idS = results.getString("id");
				String Firstname = results.getString("firstname");
				String Lastname = results.getString("lastname");
				String Username = results.getString("username");
				String Password = results.getString("password");
				String email = results.getString("email");
				String dob = results.getString("dob");
				String teamID = results.getString("team_id");
				
				int id1 = Integer.parseInt(idS);
				Date dob1 = java.sql.Date.valueOf(dob);
				int Tid = Integer.parseInt(teamID);
				TeamImpl TIMPL = new TeamImpl();
				sponsor = new Sponsor(id1, Firstname, Lastname, 
						Username, Password, email, dob1,TIMPL.findTeamById(Tid));
			}
			return sponsor;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
	}		
		

}
