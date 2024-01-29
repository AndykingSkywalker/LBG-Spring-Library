package com.lbg.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.library.domains.Person;
import com.lbg.library.repos.PersonRepo;

@Service
public class PersonServices {

	private PersonRepo repo;

	public PersonServices(PersonRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Person> createPerson(Person newPerson) {
		Person created = this.repo.save(newPerson);
		return new ResponseEntity<Person>(created, HttpStatus.CREATED);
	}

	public List<Person> getPeople() {
		return this.repo.findAll();
	}

	public ResponseEntity<Person> getPerson(int id) {
		Optional<Person> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
		Person body = found.get();
		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Person> updatePerson(int id, Person personDetails) {
		Optional<Person> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
		Person existing = found.get();

		if (personDetails.getName() != null) {
			existing.setName(personDetails.getName());
		}
		if (personDetails.getAge() != null) {
			existing.setAge(personDetails.getAge());
		}

		if (personDetails.getItems() != null) {
			existing.setItems(personDetails.getItems());
		}

		Person updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);
	}

	public boolean deletePerson(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
