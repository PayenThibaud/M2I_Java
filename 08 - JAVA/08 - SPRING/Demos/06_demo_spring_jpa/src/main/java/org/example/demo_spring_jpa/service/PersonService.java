package org.example.demo_spring_jpa.service;

import org.example.demo_spring_jpa.dao.PersonRepository;
import org.example.demo_spring_jpa.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findById(int id){
        return personRepository.findById(id).orElse(null);
    }

    public Person save(Person person){
        return personRepository.save(person);
    }

    public void delete(Person person){
        personRepository.delete(person);
    }
}
