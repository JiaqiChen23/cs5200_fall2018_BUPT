package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.Connect;
import edu.northeastern.cs5200.model.Team;

public class TeamImpl implements TeamDao{
	Connection connect = Connect.getConnection();

	@Override
	public void createTeam(Team team) {
		String findAllDevelopersSql = "INSERT INTO team (id,description,sponsor_amount,title) VALUES (?,?,?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setInt(1, team.getId());
			statement1.setString(2, team.getDescription());
			statement1.setInt(3, team.getSponsorAmount());
			statement1.setString(4, team.getTitle());
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}		
	}

	@Override
	public Collection<Team> findAllTeams() {
		String findAllDevelopersSql = "SELECT * FROM team";
		List<Team> teams = new ArrayList<Team>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String Description = results.getString("description");
				String sponsoramount = results.getString("sponsor_amount");
				String Title = results.getString("title");
				
				int id1 = Integer.parseInt(idS);
				int sponamount = Integer.parseInt(sponsoramount);
				SponsorImpl SIMPL = new SponsorImpl();
				Team team = new Team();
				team = new Team(id1, Description, sponamount,Title);
				team.setSpon(SIMPL.findSponsorByTeamId(id1));
				teams.add(team);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return teams;
	}

	@Override
	public Team findTeamById(int id) {
		String findAllDevelopersSql = "SELECT * FROM team WHERE id ="+id;
		Statement statement = null;
		ResultSet results = null;
		Team team = new Team();
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String Description = results.getString("description");
				String sponsoramount = results.getString("sponsor_amount");
				String Title = results.getString("title");
				
				int id1 = Integer.parseInt(idS);
				int sponamount = Integer.parseInt(sponsoramount);
				team = new Team(id1, Description, sponamount,Title);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return team;
	}

	@Override
	public Team findTeamByBossId(int id) {
		BossImpl BIMPL = new BossImpl();
		int Tid = BIMPL.findBossById(id).getTeam().getId();
		String findAllDevelopersSql = "SELECT * FROM team WHERE id ="+Tid;
		Statement statement = null;
		ResultSet results = null;
		Team team = new Team();
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String Description = results.getString("description");
				String sponsoramount = results.getString("sponsor_amount");
				String Title = results.getString("title");
				
				int id1 = Integer.parseInt(idS);
				int sponamount = Integer.parseInt(sponsoramount);
				team = new Team(id1, Description, sponamount,Title);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return team;
	}

	@Override
	public Team findTeamBySponsorId(int id) {
		SponsorImpl SIMPL = new SponsorImpl();
		int Tid = SIMPL.findSponsorById(id).getTeam().getId();
		String findAllDevelopersSql = "SELECT * FROM team WHERE id ="+Tid;
		Statement statement = null;
		ResultSet results = null;
		Team team = new Team();
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String Description = results.getString("description");
				String sponsoramount = results.getString("sponsor_amount");
				String Title = results.getString("title");
				
				int id1 = Integer.parseInt(idS);
				int sponamount = Integer.parseInt(sponsoramount);
				team = new Team(id1, Description, sponamount,Title);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return team;
	}

	@Override
	public void updateTeamById(int id, Team team) {
		String findAllDevelopersSql = "UPDATE team SET "
				+ "description=?,sponsor_amount=?,title=?  WHERE id =?";
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setString(1, team.getDescription());
			statement.setInt(2, team.getSponsorAmount());
			statement.setString(3, team.getTitle());
			statement.setInt(4, id);

			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return;	
		
	}

	@Override
	public void deleteTeamById(int id) {
		String findAllDevelopersSql = "DELETE FROM team WHERE id = ?";		
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
