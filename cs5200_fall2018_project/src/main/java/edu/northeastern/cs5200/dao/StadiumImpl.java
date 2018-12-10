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
import edu.northeastern.cs5200.model.Stadium;
import edu.northeastern.cs5200.model.Team;

public class StadiumImpl implements StadiumDao{
	Connection connect = Connect.getConnection();

	@Override
	public void createStadium(Stadium stadium) {
		String findAllDevelopersSql = "INSERT INTO stadium (id,name,team_id,seats) VALUES (?,?,?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setInt(1, stadium.getId());
			statement1.setString(2, stadium.getName());
			statement1.setInt(3, stadium.getTeam().getId());
			statement1.setInt(4, stadium.getSeats());
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}	
	}

	@Override
	public Collection<Stadium> findAllStadium() {
		String findAllDevelopersSql = "SELECT * FROM stadium";
		List<Stadium> stadiums = new ArrayList<Stadium>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String name = results.getString("name");
				String Teamid = results.getString("team_id");
				String SeatsS = results.getString("seats");
				
				int id1 = Integer.parseInt(idS);
				int Tid = Integer.parseInt(Teamid);
				int Seats = Integer.parseInt(SeatsS);
				Stadium stadium = new Stadium();
				TeamImpl TIMPL = new TeamImpl();
				stadium = new Stadium(id1, name,TIMPL.findTeamById(Tid),Seats);
				stadiums.add(stadium);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return stadiums;
	}

	@Override
	public Stadium findStadiumById(int id) {
		String findAllDevelopersSql = "SELECT * FROM stadium WHERE id ="+id;
		Statement statement = null;
		ResultSet results = null;
		Stadium stadium = new Stadium();
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String name = results.getString("name");
				String Teamid = results.getString("team_id");
				String SeatsS = results.getString("seats");
				
				int id1 = Integer.parseInt(idS);
				int Tid = Integer.parseInt(Teamid);
				int Seats = Integer.parseInt(SeatsS);
				TeamImpl TIMPL = new TeamImpl();
				stadium = new Stadium(id1, name,TIMPL.findTeamById(Tid),Seats);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return stadium;
	}

	@Override
	public Stadium findStadiumByTeamId(int id) {
		TeamImpl TIMPL = new TeamImpl();
		int Tid = TIMPL.findTeamById(id).getId();
		String findAllDevelopersSql = "SELECT * FROM stadium WHERE id ="+Tid;
		Statement statement = null;
		ResultSet results = null;
		Stadium stadium = new Stadium();
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String name = results.getString("name");
				String Teamid = results.getString("team_id");
				String SeatsS = results.getString("seats");
				int Seats = Integer.parseInt(SeatsS);
				int id1 = Integer.parseInt(idS);
				int Tid1 = Integer.parseInt(Teamid);
				stadium = new Stadium(id1, name,TIMPL.findTeamById(Tid1),Seats);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return stadium;
	}

	@Override
	public void updateStadiumById(int id, Stadium stadium) {
		String findAllDevelopersSql = "UPDATE stadium SET "
				+ "name=?,team_id=?,seats=?  WHERE id =?";
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setString(1, stadium.getName());
			statement.setInt(2, stadium.getTeam().getId());
			statement.setInt(3, id);
			statement.setInt(4, stadium.getSeats());

			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return;	
	}

	@Override
	public void deleteStadiumById(int id) {
		String findAllDevelopersSql = "DELETE FROM stadium WHERE id = ?";		
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
