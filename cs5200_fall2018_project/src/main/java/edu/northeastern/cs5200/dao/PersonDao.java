package edu.northeastern.cs5200.dao;

import java.util.Collection;

import edu.northeastern.cs5200.model.Person;

public interface PersonDao {
	
	public void createPerson(Person person,String dtype);
	
	public Collection<Person> findAllPerson();

	public Person findPersonByUP(String username, String password);
}
