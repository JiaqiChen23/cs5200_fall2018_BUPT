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
import edu.northeastern.cs5200.model.Allstar;
import edu.northeastern.cs5200.model.Report;

public class AllstarImpl implements AllstarDao{
	Connection connect = Connect.getConnection();

	@Override
	public void createAllstars(Allstar allstar) {
		String findAllDevelopersSql = "INSERT INTO allstar (id,fans_id,player_id) VALUES (?,?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setInt(1, allstar.getId());
			statement1.setInt(2, allstar.getFan().getId());
			statement1.setInt(3, allstar.getPlayer().getId());
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}	
	}

	@Override
	public Collection<Allstar> findAllAllstars() {
		String findAllDevelopersSql = "SELECT * FROM allstar";
		List<Allstar> allstars = new ArrayList<Allstar>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String Fanid = results.getString("fans_id");
				String Playerid = results.getString("player_is");
				
				int id = Integer.parseInt(idS);
				int Fid = Integer.parseInt(Fanid);
				int Pid = Integer.parseInt(Playerid);
				Allstar allstar = new Allstar();
				FanImpl FIMPL = new FanImpl();
				PlayerImpl PIMPL = new PlayerImpl();
				
				allstar = new Allstar(id, FIMPL.findFanById(Fid),PIMPL.findPlayerById(Pid));
				allstars.add(allstar);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return allstars;
	}

	@Override
	public Allstar findAllstarById(int id) {
		String findAllDevelopersSql = "SELECT * FROM allstar WHERE id ="+id;
		Statement statement = null;
		ResultSet results = null;
		Allstar allstar = new Allstar();
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);

			while(results.next()) {
				String idS = results.getString("id");
				String Fanid = results.getString("fans_id");
				String Playerid = results.getString("player_is");
				
				int id1 = Integer.parseInt(idS);
				int Fid = Integer.parseInt(Fanid);
				int Pid = Integer.parseInt(Playerid);
				FanImpl FIMPL = new FanImpl();
				PlayerImpl PIMPL = new PlayerImpl();
				
				allstar = new Allstar(id1, FIMPL.findFanById(Fid),PIMPL.findPlayerById(Pid));
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return allstar;
	}

	@Override
	public void updateAllstarsById(int id, Allstar allstars) {
		String findAllDevelopersSql = "UPDATE allstar SET "
				+ "fans_id=?,player_id=?  WHERE id =?";
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setInt(1, allstars.getFan().getId());
			statement.setInt(2, allstars.getPlayer().getId());
			statement.setInt(3, id);

			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return;	
	}

	@Override
	public void deleteAllstarsById(int id) {
		String findAllDevelopersSql = "DELETE FROM allstar WHERE id = ?";		
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
