package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Person;

public interface PersonDAO {

	public void insertPerson(Person person);

	public Person getPersonById(int id);

	public List<Person> getAllPersons();

	public void updatePerson(Person person);

	public void deletePerson(int id);

}
