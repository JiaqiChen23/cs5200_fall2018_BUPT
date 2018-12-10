package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Allstar;

public interface AllstarDao {

	public void createAllstars(Allstar allstar);
	
	public Collection<Allstar> findAllAllstars();
	
	public Allstar findAllstarById(int id);
	
	public Collection<Allstar> findAllstarByFanId(int id);
	
	public Collection<Allstar> findAllstarByPlayerId(int id);
	
	public void deleteAllstarsByFanId(int fId,int pid);
	
	public void updateAllstarsById(int id, Allstar allstars);
	
	public void deleteAllstarsById(int id);
}
