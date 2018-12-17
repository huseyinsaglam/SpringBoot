package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.model.PersonList;

@RestController
@RequestMapping("/rest")
public class JSONPersonController {

	//
	// JAXB -> java architecutre for xml binding
	// xml -> extensible markup language

	@RequestMapping(method=RequestMethod.GET , value="/getPersonXML")
	public Person getPersonXML() {
		return new Person("1", "Huseyin", "Saglam", "1995");
	}

	@RequestMapping(method=RequestMethod.GET , value="/getPersonListXML")
	public PersonList getPersonListXML() {
		// prepare data
		Person person1 = new Person("1", "Huseyin", "Saglam", "1995");
		Person person2 = new Person("2", "Okan", "Karahan", "1994");
		Person person3 = new Person("3", "Sebahattin", "Guclu", "1993");

		List<Person> persons = new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);

		PersonList personList = new PersonList(persons);

		return personList;
	}

	// geriye List<Person> donmeye calisirsak!
	// // HTTP Status 500 - Request processing failed; nested exception is
	// java.lang.IllegalArgumentException: No converter found for return value
	// of type: class java.util.ArrayList
}