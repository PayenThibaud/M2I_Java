package org.example.spring_exo2.service;

import org.example.spring_exo2.model.Etudient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EtudientService {

    private List<Etudient> etudients;

    public EtudientService() {
        etudients = new ArrayList<>();

        Etudient e1 = new Etudient("Titi", "Riri", "Titi@gmail.com", 20);
        Etudient e2 = new Etudient("Toto", "Roro", "Toto@gmail.com", 17);
        Etudient e3 = new Etudient("Tata", "Rara", "Tata@gmail.com", 24);

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
        List<Etudient> etudientsByName = new ArrayList<>();
        return etudientsByName.stream().filter(e -> e.getNom().equals(name)).toList();
    }
}

