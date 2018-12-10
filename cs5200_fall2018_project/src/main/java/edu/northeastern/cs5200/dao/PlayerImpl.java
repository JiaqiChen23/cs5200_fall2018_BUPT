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
import edu.northeastern.cs5200.model.Player;

public class PlayerImpl implements PlayerDao{
	Connection connect = Connect.getConnection();
	@Override
	public void createPlayer(Player player) {
		String findAllDevelopersSql = "INSERT INTO player (id,name,team_id) VALUES (?,?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setInt(1, player.getId());
			statement1.setString(2, player.getName());
			statement1.setInt(3, player.getTeam().getId());
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}	
	}

	@Override
	public Collection<Player> findAllPlayer() {
		String findAllDevelopersSql = "SELECT * FROM player";
		List<Player> players = new ArrayList<Player>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String name = results.getString("name");
				String Teamid = results.getString("team_id");
				
				int id = Integer.parseInt(idS);
				int Tid = Integer.parseInt(Teamid);
				Player player = new Player();
				TeamImpl TIMPL = new TeamImpl();
				
				player = new Player(id, name,TIMPL.findTeamById(Tid));
				players.add(player);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return players;
	}

	@Override
	public Player findPlayerById(int id) {
		String findAllDevelopersSql = "SELECT * FROM player WHERE id ="+id;
		Statement statement = null;
		ResultSet results = null;
		Player player = new Player();

		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String name = results.getString("name");
				String Teamid = results.getString("team_id");
				
				int id1 = Integer.parseInt(idS);
				int Tid = Integer.parseInt(Teamid);
				TeamImpl TIMPL = new TeamImpl();
				
				player = new Player(id1, name, TIMPL.findTeamById(Tid));
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return player;
	}

	@Override
	public Collection<Player> findPlayerByTeamId(int id) {
		String findAllDevelopersSql = "SELECT * FROM player WHERE team_id ='"+id+"'";
		List<Player> players = new ArrayList<Player>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String name = results.getString("name");
				String Teamid = results.getString("team_id");
				
				int id1 = Integer.parseInt(idS);
				int Tid = Integer.parseInt(Teamid);
				Player player = new Player();
				TeamImpl TIMPL = new TeamImpl();
				
				player = new Player(id1, name,TIMPL.findTeamById(Tid));
				players.add(player);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return players;
	}

	@Override
	public void updatePlayerById(int id, Player player) {
		String findAllDevelopersSql = "UPDATE player SET "
				+ "name=?, team_id=?  WHERE id =?";
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setString(1, player.getName());
			statement.setInt(2, player.getTeam().getId());
			statement.setInt(3, id);

			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return;	
	}

	@Override
	public void deletePlayerById(int id) {
		String findAllDevelopersSql = "DELETE FROM player WHERE id = ?";		
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
	public void createPlayerNoTeamId(Player player) {
		String findAllDevelopersSql = "INSERT INTO player (id,name) VALUES (?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setInt(1, player.getId());
			statement1.setString(2, player.getName());
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

}
