package org.example.Repository;

import org.example.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentRepository  extends  BaseRepository<Student>{

//    private EntityManager em;

    public StudentRepository(EntityManager em) {
        super(em);
    }

//    public Student save (Student student){
//        em.getTransaction().begin();
//        em.persist(student);
//        em.getTransaction().commit();
//        return student;
//    }
//
//    public Student find(int id){
//        return em.find(Student.class,id);
//    }
//
//    public boolean delete (int id){
//        Student student = find(id);
//        if(student != null){
//            em.getTransaction().begin();
//            em.remove(student);
//            em.getTransaction().commit();
//            return true;
//        }else{
//            System.out.println("no student found");
//        }
//        return false;
//    }
//
//    public List<Student> getALl (){
//        // requete JPQL sembleble au sql mais avec l'utilisation de l'orienté objet dedans
//        return em.createQuery("select s from Student as s", Student.class).getResultList();
//    }
//
//    public List<Student> getByClass (String classe){
//        TypedQuery<Student> query = em.createQuery("select s from Student s where s.classe = :classe", Student.class);
//        query.setParameter("classe",classe);
//        return query.getResultList();
//    }
}
