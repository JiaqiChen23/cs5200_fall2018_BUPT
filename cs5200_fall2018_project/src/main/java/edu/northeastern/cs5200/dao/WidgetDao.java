package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Player;

public interface WidgetDao {
	public void createWidgetForPage(int pageId, Player widget);
	public Collection<Player> findAllWidgets();
	public Player findWidgetById(int widgetId);
	public Collection<Player> findWidgetsForPage(int pageId);
	public int updateWidget(int widgetId, Player widget);
	public int deleteWidget(int widgetId);
}
