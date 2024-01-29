package com.lbg.library.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.library.domains.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
