package edu.northeastern.cs5200;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Connect {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://cs5200-fall2018-charles-project.cdgao9scgr84.us-east-2.rds.amazonaws.com:3306/cs5200_project";
	private static final String USER = "charles";
	private static final String PASSWORD = "password";
	private static 	java.sql.Connection dbConnection = null;

	public static Connection getConnection(){
    	try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	if (dbConnection == null) {
		try {
			dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbConnection;
	} else { return dbConnection; } }
	
	public static void closeConnection() {
   	 try {
   		 if (dbConnection != null) {
		dbConnection.close();
		dbConnection = null; }
   	 } catch (SQLException e) {
   		 // TODO Auto-generated catch block
   		 e.printStackTrace();
   	 }
	}
	

}
