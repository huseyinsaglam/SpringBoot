package com.example.demo.model;

import java.util.List;




public class PersonList {


	private List<Person> personList;
	
	public PersonList() {
		super();
	}

	public PersonList(List<Person> personList) {
		super();
		this.personList = personList;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

}
