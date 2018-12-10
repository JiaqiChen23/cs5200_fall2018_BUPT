package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Player;

public interface PlayerDao {

	public void createPlayer(Player player);
	
	public Collection<Player> findAllPlayer();
	
	public Player findPlayerById(int id);
	
	public Collection<Player> findPlayerByTeamId(int id);
	
	public void updatePlayerById(int id, Player player);
	
	public void deletePlayerById(int id);

	void createPlayerAutoId(Player player);
}
