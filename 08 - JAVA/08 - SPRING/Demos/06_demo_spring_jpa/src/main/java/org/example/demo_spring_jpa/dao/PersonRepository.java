package org.example.demo_spring_jpa.dao;

import org.example.demo_spring_jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByFirstnameAndLastname(String firstname, String lastname);
}
