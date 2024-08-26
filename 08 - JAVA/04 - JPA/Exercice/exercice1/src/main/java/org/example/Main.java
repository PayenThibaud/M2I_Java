package org.example;

import org.example.Repository.StudentRepository;
import org.example.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exo1");
        EntityManager em = emf.createEntityManager();

        StudentRepository studentRepository = new StudentRepository(em);

        Student student = Student.builder().firstname("titi").lastname("tutu").classe("classe2").build();

        studentRepository.save(student);

        System.out.println(studentRepository.find(1));

        System.out.println("liste des etudiants");

        studentRepository.getALl().forEach(System.out::println);

    }
}