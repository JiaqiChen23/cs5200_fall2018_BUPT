package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Sponsor;

public interface SponsorDao {

	public void createSponsor(Sponsor sponsor);
	
	public Collection<Sponsor> findAllSponsors();
	
	public Sponsor findSponsorById(int id);
	
	public Sponsor findSponsorByCredentials(String username, int password);
	
	public void updateSponsorById(int id, Sponsor sponsor);
	
	public void deleteSponsorById(int id);
}
