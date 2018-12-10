package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.Connect;
import edu.northeastern.cs5200.model.Fan;
import edu.northeastern.cs5200.model.Person;

public class PersonImpl implements PersonDao{
	Connection connect = Connect.getConnection();

	@Override
	public void createPerson(Person person,String dtype) {
		String findAllDevelopersSql = "INSERT INTO person (dtype,type,dob,email,firstname,lastname,password,username) VALUES (?,?,?,?,?,?,?,?);";		
		try {
			PreparedStatement statement1 = 
					connect.prepareStatement(findAllDevelopersSql);
			statement1.setString(1, dtype);
			statement1.setString(2, dtype);
			statement1.setDate(3, person.getDob());
			statement1.setString(4, person.getEmail());
			statement1.setString(5, person.getFirstname());
			statement1.setString(6, person.getLastname());
			statement1.setString(7, person.getPassword());
			statement1.setString(8, person.getUsername());
			statement1.executeUpdate();
			
		} catch (SQLException e2) {
			e2.printStackTrace();
		}	
	}

	@Override
	public List<Person> findAllPerson() {
		String findAllDevelopersSql = "SELECT * FROM person";
		List<Person> persons = new ArrayList<Person>();
		Statement statement = null;
		ResultSet results = null;
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String dtype = results.getString("dtype");
				String idS = results.getString("id");
				String Firstname = results.getString("firstname");
				String Lastname = results.getString("lastname");
				String Username = results.getString("username");
				String Password = results.getString("password");
				String email = results.getString("email");
				String dob = results.getString("dob");
				
				int id1 = Integer.parseInt(idS);
				Date dob1 = java.sql.Date.valueOf(dob);
				Person person = new Person();
				person = new Person(dtype,id1, Firstname, Lastname, 
						Username, Password, email, dob1);
				persons.add(person);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return persons;
	}
	@Override
	public Person findPersonByUP(String username, String password) {
		String findAllDevelopersSql = "SELECT * FROM person WHERE "
				+ "username='"+username+"'and password='"+password+"'";
		Statement statement = null;
		ResultSet results = null;
		Person person = new Person();
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(findAllDevelopersSql);
			
			while(results.next()) {
				String dtype = results.getString("type");
				System.out.println(dtype);
				String idS = results.getString("id");
				String Firstname = results.getString("firstname");
				String Lastname = results.getString("lastname");
				String Username = results.getString("username");
				String Password = results.getString("password");
				String email = results.getString("email");
				String dob = results.getString("dob");
				
				int id1 = Integer.parseInt(idS);
				Date dob1 = java.sql.Date.valueOf(dob);
				person = new Person(dtype,id1, Firstname, Lastname, 
						Username, Password, email, dob1);
			}
						
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return person;
	}

	@Override
	public void deletePersonById(int id) {
		String findAllDevelopersSql = "DELETE FROM person WHERE id = ?";		
		try {
			PreparedStatement statement = connect.prepareStatement(findAllDevelopersSql);
			statement.setInt(1,id);
			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}		return;	
	}
	
	@Override
	public void updatePersonById(int id, Person person) {
		String findAllDevelopersSql = "UPDATE person SET dtype=?,"
				+ "dob=?,email=?,firstname=?,"
				+ "lastname=?,password=?,username=?,type=?  WHERE id =?";
		try {
			PreparedStatement statement = 
					connect.prepareStatement(findAllDevelopersSql);
			statement.setString(1, person.getType());
			statement.setDate(2, person.getDob());
			statement.setString(3, person.getEmail());
			statement.setString(4, person.getFirstname());
			statement.setString(5, person.getLastname());
			statement.setString(6, person.getPassword());
			statement.setString(7, person.getUsername());
			statement.setString(8, person.getType());
			statement.setInt(9, id);

			statement.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return;	
	}

}
