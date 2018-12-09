package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Draft;

public interface DraftDao {

	public void createDraft(Draft draft);
	
	public Collection<Draft> findAllDrafts();
	
	public Draft findDraftById(int id);
	
	public Draft findDraftByPlayerId(int id);
	
	public Collection<Draft> findDraftsByTeamAndYear(int teamId, int year);
	
	public Collection<Draft> findDraftsByYear(int year);
	
	public void updateDraftById(int id, Draft draft);
	
	public void deleteDraftById(int id);
}
