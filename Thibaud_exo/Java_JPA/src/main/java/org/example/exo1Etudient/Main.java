package org.example.exo1Etudient;

import org.example.exo1Etudient.Repository.AdresseRepository;
import org.example.exo1Etudient.Repository.CourRepository;
import org.example.exo1Etudient.Repository.EtudientRepository;
import org.example.exo1Etudient.Repository.ExamenRepository;
import org.example.exo1Etudient.entity.Adresse;
import org.example.exo1Etudient.entity.Cour;
import org.example.exo1Etudient.entity.Etudient;
import org.example.exo1Etudient.entity.Examen;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA");
        EntityManager em = emf.createEntityManager();

        AdresseRepository adresseRepository = new AdresseRepository(em);
        EtudientRepository etudientRepository = new EtudientRepository(em);
        ExamenRepository examenRepository = new ExamenRepository(em);
        CourRepository courRepository = new CourRepository(em);

        Etudient etudient = Etudient.builder()
                .nom("Titi2")
                .prenom("Toto2")
                .classe("6Ee")
                .build();

        etudientRepository.add(etudient);

        Adresse adresse = Adresse.builder()
                .numero(1)
                .rue(10)
                .ville("Lille")
                .codePostal(111)
                .build();

        adresseRepository.add(adresse);

        Etudient etudient1 = Etudient.builder()
                .nom("Titi")
                .prenom("Toto")
                .classe("6Ee")
                .adresse(adresse)
                .build();

        etudientRepository.add(etudient1);


        Examen examen1 = Examen.builder()
                .date("2024-06-15")
                .note(85)
                .matiere("Mathématiques")
                .etudient(etudientRepository.getById(2))
                .build();

        Examen examen2 = Examen.builder()
                .date("2024-06-16")
                .note(90)
                .matiere("Physique")
                .etudient(etudientRepository.getById(2))
                .build();

        Cour cour = Cour.builder()
                .salle("E5")
                .professeur("Tata")
                .horraire("9H-10h")
                .matiere("IT")
                .build();

        courRepository.add(cour);

        examenRepository.add(examen1);
        examenRepository.add(examen2);

//        etudientRepository.addExamenInEtudient(2,List.of(examen1, examen2));

        System.out.println(etudientRepository.getById(2));

        etudientRepository.addCourInEtudient(3,List.of(courRepository.getById(6)));

        System.out.println(etudientRepository.getById(2));

    }

}