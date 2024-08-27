package org.example.exo1Etudient.Repository;

import org.example.exo1Etudient.entity.Adresse;
import org.example.exo1Etudient.entity.Cour;
import org.example.exo1Etudient.entity.Etudient;
import org.example.exo1Etudient.entity.Examen;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class EtudientRepository {

    private EntityManager em;

    public EtudientRepository(EntityManager em) {
        this.em = em;
    }

    public void add(Etudient etudient) {
        em.getTransaction().begin();
        em.persist(etudient);
        em.getTransaction().commit();
    }

    public void update(int id, Etudient etudientUpdate) {

        Etudient etudient = getById(id);

        if (etudient == null) {
            System.out.println("pas d etudient avec cet id");
            return;
        }
        em.getTransaction().begin();

        etudient.setNom(etudientUpdate.getNom());
        etudient.setPrenom(etudientUpdate.getPrenom());

        if (etudientUpdate.getClasse() != null) {
            Adresse adresseUpdate = etudientUpdate.getAdresse();
            if (adresseUpdate != null) {
            }
        }

        if (etudientUpdate.getAdresse() != null) {
            Adresse adresseUpdate = etudientUpdate.getAdresse();
            if (adresseUpdate.getId() == 0) {
                em.persist(adresseUpdate);
            }
            etudient.setAdresse(adresseUpdate);
        }

        em.merge(etudient);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        Etudient etudient = getById(id);
        if (etudient == null) {
            System.out.println("pas d etudient avec cet id");
            return;
        }
        em.getTransaction().begin();
        em.remove(etudient);
        em.getTransaction().commit();
    }

    public Etudient getById(int id) {
        Etudient etudient = em.find(Etudient.class, id);
        if (etudient != null) {
            return etudient;
        } else {
            System.out.println("pas d etudient avec cet id");
            return etudient;
        }
    }

    public List<Etudient> getAll() {
        TypedQuery<Etudient> query = em.createQuery("select e from Etudient e", Etudient.class);
        return query.getResultList();
    }

    public void addExamenInEtudient(int EtudientId, List<Examen> examenList) {
        Etudient etudient = getById(EtudientId);

        if (etudient == null) {
            System.out.println("pas d etudient avec cet id");
            return;
        }

        em.getTransaction().begin();
        for (Examen examen : examenList) {
            if (examen.getId() > 0) {
                examen.setEtudient(etudient);
            }
        }
        etudient.getExamens().addAll(examenList);

        em.merge(etudient);
        em.getTransaction().commit();
    }

    public void addCourInEtudient(int EtudientId, List<Cour> cours) {
        Etudient etudient = getById(EtudientId);

        if (etudient == null) {
            System.out.println("pas d etudient avec cet id");
            return;
        }

        em.getTransaction().begin();
        for (Cour cour : cours) {
            if (cour.getId() > 0) {
                if (cour.getEtudients() == null) {
                    cour.setEtudients(new ArrayList<>());
                }
                cour.addEtudient(etudient);
            }
        }
        if (etudient.getCours() == null) {
            etudient.setCours(new ArrayList<>());
        }
        etudient.getCours().addAll(cours);

        em.merge(etudient);
        em.getTransaction().commit();
    }

    public double calculMoyenne(int idEtudient) {
        Etudient etudient = getById(idEtudient);
        if (etudient == null) {
            System.out.println("pas d etudient avec cet id");
            return 0;
        }

        List<Examen> examens = etudient.getExamens();
        if (examens == null || examens.isEmpty()) {
            System.out.println("L etudient n a pas encore d examen");
            return 0;
        }

        double moyenne = 0;
        double nombreExamen = 0;
        for (Examen examen : examens) {
            if (examen.getId() > 0) {
                moyenne = moyenne + examen.getNote();
                nombreExamen++;
            }
        }

        if (nombreExamen == 0) {
            return 0;
        } else {
            return (moyenne / nombreExamen);
        }
    }

    public List<Examen> getExamenByEtudientAndMatiere(int etudientId, String matiere) {
        Etudient etudient = getById(etudientId);
        if (etudient == null) {
            System.out.println("pas d etudient avec cet id");
            return null;
        }

        List<Examen> examens = etudient.getExamens();
        if (examens == null || examens.isEmpty()) {
            System.out.println("L etudient n a pas encore d examen");
            return null;
        }

        List<Examen> examenTrierMatiere = new ArrayList<>();

        for (Examen examen : examens) {
            if (matiere.equalsIgnoreCase(examen.getMatiere())) {
                examenTrierMatiere.add(examen);
            }
        }

        return examenTrierMatiere;

    }
}
