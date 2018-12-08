package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Boss;

public interface BossDao {

	public void createBoss(Boss boss);
	
	public Collection<Boss> findAllBoss();
	
	public Boss findBossById(int id);
	
	public Boss findBossByCredentials(String username, int password);
	
	public void updateBossById(int id, Boss boss);
	
	public void deleteBossById(int id);
}
