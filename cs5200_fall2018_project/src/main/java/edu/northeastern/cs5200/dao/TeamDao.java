package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Team;

public interface TeamDao {

	public void createTeam(Team team);
	
	public Collection<Team> findAllTeams();
	
	public Team findTeamById(int id);
	
	public void updateTeamById(int id, Team team);
	
	public void deleteTeamById(int id);
}
