package com.lbg.library.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.library.domains.Person;
import com.lbg.library.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	private PersonServices service;

	public PersonController(PersonServices service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Person> createPerson(@RequestBody Person newPerson) {
		return this.service.createPerson(newPerson);
	}

	@GetMapping("/get")
	public List<Person> getPeople() {
		return this.service.getPeople();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable int id) {
		return this.service.getPerson(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person personDetails) {
		return this.service.updatePerson(id, personDetails);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deletePerson(@PathVariable int id) {
		return this.service.deletePerson(id);
	}
}
