package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.Connect;
import edu.northeastern.cs5200.model.HeadingWidget;
import edu.northeastern.cs5200.model.HtmlWidget;
import edu.northeastern.cs5200.model.ImageWidget;
import edu.northeastern.cs5200.model.Team;
import edu.northeastern.cs5200.model.Player;
import edu.northeastern.cs5200.model.YouTubeWidget;

public class WidgetImpl implements WidgetDao{
	Connection connect = Connect.getConnection();

	@Override
	public void createWidgetForPage(int pageId, Player widget) {
		try {
		String findAllDevelopersSql = "INSERT INTO widget (id, name, width, height, cssClass, cssStyle, text, "
				 + "ordernum, page_id, dtype, url, sharable, expandable, source, size, html)"
				 + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = 
				connect.prepareStatement(findAllDevelopersSql);
   statement.setInt(1, widget.getId());  
   statement.setString(2, widget.getName());
   statement.setInt(3, widget.getWidth());
   statement.setInt(4, widget.getHeight());
   statement.setString(5, widget.getCssclass());
   statement.setString(6, widget.getCssstyle());
   statement.setString(7, widget.getText());
   statement.setInt(8, widget.getOrdernum());
   statement.setInt(9, pageId);
   statement.setString(10, widget.getDtype().name());
   System.out.println("123");
   if(widget instanceof YouTubeWidget){
       YouTubeWidget inst = (YouTubeWidget) widget;
       statement.setString(11, inst.getUrl());
       statement.setBoolean(12, inst.isSharable());
       statement.setBoolean(13, inst.isExpandable());
   }else{
       statement.setString(11, "");
       statement.setBoolean(12, false);
       statement.setBoolean(13, false);
   }
   if(widget instanceof ImageWidget){
       ImageWidget inst = (ImageWidget) widget;
       statement.setString(14, inst.getSource());
   }else{
       statement.setString(14, "");
   }
   if(widget instanceof HeadingWidget){
       HeadingWidget inst = (HeadingWidget) widget;
       statement.setInt(15, inst.getSize());
   }else{
		statement.setInt(15, 0);
   }
   if(widget instanceof HtmlWidget){
       HtmlWidget inst = (HtmlWidget) widget;
       statement.setString(16, inst.getHtml());
   }else{
       statement.setString(16, "");
   }
   statement.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}			
	}

	@Override
	public Collection<Player> findAllWidgets() {
		String findAllDevelopersSql = "SELECT * FROM widget";
		List<Player> widgets = new ArrayList<Player>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
//			ResultSetMetaData rsmd = results.getMetaData();
//			int columnsNumber = rsmd.getColumnCount();
//			while (results.next()) {
//			    for (int i = 1; i <= columnsNumber; i++) {
//			        if (i > 1) System.out.print(",  ");
//			        String columnValue = results.getString(i);
//			        System.out.print(columnValue + " " + rsmd.getColumnName(i));
//			    }
//			    System.out.println("");
//			}

			while(results.next()) {
				String idS = results.getString("id");
				String dtype = results.getString("dtype");
				String cssclass = results.getString("cssclass");
				String cssstyle = results.getString("cssstyle");
				String heightS = results.getString("height");
				String widthS = results.getString("width");
				String name = results.getString("name");
				String ordernumS = results.getString("ordernum");
				String text = results.getString("text");
				String page_idS = results.getString("page_id");

				int height = Integer.parseInt(heightS);
				int id = Integer.parseInt(idS);
				int width = Integer.parseInt(widthS);
				int ordernum = Integer.parseInt(ordernumS);
				int page_id = Integer.parseInt(page_idS);

				PageImpl PI = new PageImpl();
				Player widget = new Player(id,name,width,height,cssclass,cssstyle,text,ordernum,PI.findPageById(page_id));
				widgets.add(widget);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return widgets;
	}

	@Override
	public Player findWidgetById(int widgetId) {
		String findAllDevelopersSql = "SELECT * FROM widget WHERE id = "+widgetId;
		Statement statement = null;
		ResultSet results = null;
		Player widget = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			while(results.next()) {
				String idS = results.getString("id");
				String dtype = results.getString("dtype");
				String cssclass = results.getString("cssclass");
				String cssstyle = results.getString("cssstyle");
				String heightS = results.getString("height");
				String widthS = results.getString("width");
				String name = results.getString("name");
				String ordernumS = results.getString("ordernum");
				String text = results.getString("text");
				String page_idS = results.getString("page_id");
	
				int height = Integer.parseInt(heightS);
				int id = Integer.parseInt(idS);
				int width = Integer.parseInt(widthS);
				int ordernum = Integer.parseInt(ordernumS);
				int page_id = Integer.parseInt(page_idS);
	
				PageImpl PI = new PageImpl();
				widget = new Player(id,name,width,height,cssclass,cssstyle,text,ordernum,PI.findPageById(page_id));
			}
			return widget;
		} catch (SQLException e2) {
			e2.printStackTrace();
			return null;
		}
	}

	@Override
	public Collection<Player> findWidgetsForPage(int pageId) {
		String findAllDevelopersSql = "SELECT * FROM widget WHERE page_id ="+pageId;
		List<Player> widgets = new ArrayList<Player>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);

			while(results.next()) {
				String idS = results.getString("id");
				String dtype = results.getString("dtype");
				String cssclass = results.getString("cssclass");
				String cssstyle = results.getString("cssstyle");
				String heightS = results.getString("height");
				String widthS = results.getString("width");
				String name = results.getString("name");
				String ordernumS = results.getString("ordernum");
				String text = results.getString("text");
				String page_idS = results.getString("page_id");

				int height = Integer.parseInt(heightS);
				int id = Integer.parseInt(idS);
				int width = Integer.parseInt(widthS);
				int ordernum = Integer.parseInt(ordernumS);
				int page_id = Integer.parseInt(page_idS);

				PageImpl PI = new PageImpl();
				Player widget = new Player(id,name,width,height,cssclass,cssstyle,text,ordernum,PI.findPageById(page_id));
				widgets.add(widget);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return widgets;
	}

	@Override
	public int updateWidget(int widgetId, Player widget) {
		try {
			
			
		String findAllDevelopersSql = "UPDATE widget SET name = ?, width = ?, height = ?, cssclass = ?, cssstyle = ?, "
					 + "text = ?, ordernum =?, dtype = ?, url = ?, sharable = ?, expandable = ?, source = ?, "
					 + "size = ?, html = ? WHERE id = ?";
		PreparedStatement statement = 
				connect.prepareStatement(findAllDevelopersSql);
        statement.setString(1, widget.getName());
        statement.setInt(2, widget.getWidth());
        statement.setInt(3, widget.getHeight());
        statement.setString(4, widget.getCssclass());
        statement.setString(5, widget.getCssstyle());
        statement.setString(6, widget.getText());
        statement.setInt(7, widget.getOrdernum());
        statement.setString(8, widget.getDtype().name());
        
        if(widget instanceof YouTubeWidget){
            YouTubeWidget inst = (YouTubeWidget) widget;
            statement.setString(9, inst.getUrl());
            statement.setBoolean(10, inst.isSharable());
            statement.setBoolean(11, inst.isExpandable());
        }else{
            statement.setString(9, "");
            statement.setBoolean(10, false);
            statement.setBoolean(11, false);
        }
        if(widget instanceof ImageWidget){
            ImageWidget inst = (ImageWidget) widget;
            statement.setString(12, inst.getSource());
        }else{
            statement.setString(12, "");
        }
        if(widget instanceof HeadingWidget){
            HeadingWidget inst = (HeadingWidget) widget;
            statement.setInt(13, inst.getSize());
        }else{
            statement.setInt(13, 0);
        }
        if(widget instanceof HtmlWidget){
            HtmlWidget inst = (HtmlWidget) widget;
            statement.setString(14, inst.getHtml());
        }else{
            statement.setString(14, "");
        }
        statement.setInt(15, widgetId);
		statement.executeUpdate();
		
	}catch (SQLException e){
		e.printStackTrace();
	}
	return 0;
	}

	@Override
	public int deleteWidget(int widgetId) {
		String findAllDevelopersSql = "DELETE FROM widget WHERE id = ?";		
		try {
			PreparedStatement statement = connect.prepareStatement(findAllDevelopersSql);
			statement.setInt(1,widgetId);
			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}		return 0;
	}

}
