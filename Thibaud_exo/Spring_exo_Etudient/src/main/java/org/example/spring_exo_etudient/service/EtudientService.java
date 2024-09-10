package org.example.spring_exo_etudient.service;

import org.example.spring_exo_etudient.model.Etudient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EtudientService {

    private List<Etudient> etudients;
    private int id;

    public EtudientService() {
        etudients = new ArrayList<>();

        Etudient e1 = new Etudient(id++,"Titi", "Riri", "Titi@gmail.com", 20);
        Etudient e2 = new Etudient(id++,"Toto", "Roro", "Toto@gmail.com", 17);
        Etudient e3 = new Etudient(id++,"Tata", "Rara", "Tata@gmail.com", 24);

        etudients.add(e1);
        etudients.add(e2);
        etudients.add(e3);
    }

    public void setEtudients(Etudient etudient) {
        etudients.add(etudient);
    }

    public List<Etudient> getEtudients() {
        return etudients;
    }

    public List<Etudient> getEtudientsByName(String name) {
        return etudients.stream()
                .filter(e -> e.getPrenom().equals(name))
                .toList();
    }

    public void deleteEtudientByID(int id) {
        etudients.remove(id);
    }
}
