package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Person;

public interface PersonService {

	public void insertPerson(Person person);

	public Person getPersonById(int id);

	public List<Person> getAllPersons();

	public void updatePerson(Person person);

	public void deletePerson(int id);
}
