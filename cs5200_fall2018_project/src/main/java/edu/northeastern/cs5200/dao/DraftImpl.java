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
import edu.northeastern.cs5200.model.Draft;
import edu.northeastern.cs5200.model.Report;
import edu.northeastern.cs5200.model.Team;

public class DraftImpl implements DraftDao{
	Connection connect = Connect.getConnection();

	@Override
	public void createDraft(Draft draft) {
		String findAllDevelopersSql = "INSERT INTO draft (id,order_num,year,player_id,team_id) VALUES (?,?,?,?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setInt(1, draft.getId());
			statement1.setInt(2, draft.getOrder());
			statement1.setString(3, draft.getYear());
			statement1.setInt(4, draft.getPlayer().getId());
			statement1.setInt(5, draft.getTeam().getId());
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}	
	}

	@Override
	public Collection<Draft> findAllDrafts() {
		String findAllDevelopersSql = "SELECT * FROM draft";
		List<Draft> drafts = new ArrayList<Draft>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String order = results.getString("order_num");
				String year = results.getString("year");
				String Playerid = results.getString("player_id");
				String Teamid = results.getString("team_id");
				
				int id = Integer.parseInt(idS);
				int Pid = Integer.parseInt(Playerid);
				int Tid = Integer.parseInt(Teamid);
				int ordernum = Integer.parseInt(order);
				Draft draft = new Draft();
				PlayerImpl PIMPL = new PlayerImpl();
				TeamImpl TIMPL = new TeamImpl();
				
				draft = new Draft(id, PIMPL.findPlayerById(Pid),TIMPL.findTeamById(Tid),year,ordernum);
				drafts.add(draft);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return drafts;
	}

	@Override
	public Draft findDraftById(int id) {
		String findAllDevelopersSql = "SELECT * FROM draft WHERE id ="+id;
		Statement statement = null;
		ResultSet results = null;
		Draft draft = new Draft();
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String order = results.getString("order_num");
				String year = results.getString("year");
				String Playerid = results.getString("player_id");
				String Teamid = results.getString("team_id");
				
				int id1 = Integer.parseInt(idS);
				int Pid = Integer.parseInt(Playerid);
				int Tid = Integer.parseInt(Teamid);
				int ordernum = Integer.parseInt(order);
				PlayerImpl PIMPL = new PlayerImpl();
				TeamImpl TIMPL = new TeamImpl();
				
				draft = new Draft(id1, PIMPL.findPlayerById(Pid),TIMPL.findTeamById(Tid),year,ordernum);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return draft;
	}

	@Override
	public Draft findDraftByPlayerId(int id) {
		PlayerImpl PIMPL = new PlayerImpl();
		int Pid = PIMPL.findPlayerById(id).getDraft().getId();
		String findAllDevelopersSql = "SELECT * FROM draft WHERE id ="+Pid;
		Statement statement = null;
		ResultSet results = null;
		Draft draft = new Draft();
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String order = results.getString("order_num");
				String year = results.getString("year");
				String Playerid = results.getString("player_id");
				String Teamid = results.getString("team_id");
				
				int id1 = Integer.parseInt(idS);
				int Pid1 = Integer.parseInt(Playerid);
				int Tid = Integer.parseInt(Teamid);
				int ordernum = Integer.parseInt(order);
				TeamImpl TIMPL = new TeamImpl();
				
				draft = new Draft(id1, PIMPL.findPlayerById(Pid1),TIMPL.findTeamById(Tid),year,ordernum);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return draft;
	}

	@Override
	public Collection<Draft> findDraftsByTeamAndYear(int teamId, int year) {
		String findAllDevelopersSql = "SELECT * FROM draft WHERE team_id= "
				+ teamId+" AND year = '"+year+"'";
		List<Draft> drafts = new ArrayList<Draft>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String order = results.getString("order_num");
				String yearR = results.getString("year");
				String Playerid = results.getString("player_id");
				String Teamid = results.getString("team_id");
				
				int id = Integer.parseInt(idS);
				int Pid = Integer.parseInt(Playerid);
				int Tid = Integer.parseInt(Teamid);
				int ordernum = Integer.parseInt(order);
				Draft draft = new Draft();
				PlayerImpl PIMPL = new PlayerImpl();
				TeamImpl TIMPL = new TeamImpl();
				
				draft = new Draft(id, PIMPL.findPlayerById(Pid),TIMPL.findTeamById(Tid),yearR,ordernum);
				drafts.add(draft);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return drafts;
	}

	@Override
	public void updateDraftById(int id, Draft draft) {
		String findAllDevelopersSql = "UPDATE draft SET "
				+ "order_num=?,year=?,player_id=?,team_id=?  WHERE id =?";
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setInt(1, draft.getOrder());
			statement.setString(2, draft.getYear());
			statement.setInt(3, draft.getPlayer().getId());
			statement.setInt(4, draft.getTeam().getId());
			statement.setInt(5, id);

			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return;	
	}

	@Override
	public void deleteDraftById(int id) {
		String findAllDevelopersSql = "DELETE FROM draft WHERE id = ?";		
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
