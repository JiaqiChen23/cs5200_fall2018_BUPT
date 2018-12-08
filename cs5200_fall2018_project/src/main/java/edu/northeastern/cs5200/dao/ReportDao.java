package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Report;

public interface ReportDao {

	public void createReport(Report report);
	
	public Collection<Report> findAllReport();
	
	public Report findReportById(int id);
	
	public void updateReportById(int id, Report report);
	
	public void deleteReportById(int id);
}
