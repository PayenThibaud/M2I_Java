package org.example;

import org.example.Repository.CoursRepository;
import org.example.Repository.ExamRepository;
import org.example.Repository.StudentRepository;
import org.example.entity.Adress;
import org.example.entity.Cours;
import org.example.entity.Exam;
import org.example.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exo1");
        EntityManager em = emf.createEntityManager();

        StudentRepository studentRepository = new StudentRepository(em);

        Student student = Student.builder()
                .firstname("titi")
                .lastname("tutu")
                .classe("classe2")
                .adress(Adress.builder().number("201").postalCode("012345").street("street of the city").city("city").build())
        .build();

        student = studentRepository.save(student);

//        Exam exam = Exam.builder().date(LocalDate.now()).grade(12.25f).subject("Maths").student(student).build();
//
//        ExamRepository examRepository = new ExamRepository(em);
//        examRepository.save(exam);
//
//        Cours cours = Cours.builder().teacher("teacher1").subject("Maths").room("A201").build();
//
        CoursRepository coursRepository =new CoursRepository(em);
//        coursRepository.save(cours);

        em.getTransaction().begin();
        Cours coursFound = coursRepository.findById(Cours.class,1);
        coursFound.add(student);
        em.getTransaction().commit();

    }
}