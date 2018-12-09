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
import edu.northeastern.cs5200.model.Report;
import edu.northeastern.cs5200.model.Stadium;

public class ReportImpl implements ReportDao{
	Connection connect = Connect.getConnection();

	@Override
	public void createReport(Report report) {
		String findAllDevelopersSql = "INSERT INTO stadium (id,reportbody,boss_id,scout_id) VALUES (?,?,?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setInt(1, report.getId());
			statement1.setString(2, report.getReportbody());
			statement1.setInt(3, report.getBoss().getId());
			statement1.setInt(4, report.getScout().getId());
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}	
	}

	@Override
	public Collection<Report> findAllReport() {
		String findAllDevelopersSql = "SELECT * FROM report";
		List<Report> reports = new ArrayList<Report>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String body = results.getString("reportbody");
				String Bossid = results.getString("boss_id");
				String Scoutid = results.getString("scout_id");
				
				int id = Integer.parseInt(idS);
				int Bid = Integer.parseInt(Bossid);
				int Sid = Integer.parseInt(Scoutid);
				Report report = new Report();
				BossImpl BIMPL = new BossImpl();
				ScoutImpl SIMPL = new ScoutImpl();
				
				report = new Report(id, BIMPL.findBossById(Bid),SIMPL.findScoutById(Sid),body);
				reports.add(report);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return reports;
	}

	@Override
	public Report findReportById(int id) {
		String findAllDevelopersSql = "SELECT * FROM report WHERE id ="+id;
		Statement statement = null;
		ResultSet results = null;
		Report report = new Report();
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String idS = results.getString("id");
				String body = results.getString("reportbody");
				String Bossid = results.getString("boss_id");
				String Scoutid = results.getString("scout_id");
				
				int id1 = Integer.parseInt(idS);
				int Bid = Integer.parseInt(Bossid);
				int Sid = Integer.parseInt(Scoutid);
				
				BossImpl BIMPL = new BossImpl();
				ScoutImpl SIMPL = new ScoutImpl();
				
				report = new Report(id1, BIMPL.findBossById(Bid),SIMPL.findScoutById(Sid),body);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return report;
	}

	@Override
	public void updateReportById(int id, Report report) {
		String findAllDevelopersSql = "UPDATE report SET "
				+ "reportbody=?,boss_id=?,scout_id=?  WHERE id =?";
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setString(1, report.getReportbody());
			statement.setInt(2, report.getBoss().getId());
			statement.setInt(3, report.getScout().getId());
			statement.setInt(4, id);

			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return;	
		
	}

	@Override
	public void deleteReportById(int id) {
		String findAllDevelopersSql = "DELETE FROM report WHERE id = ?";		
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
