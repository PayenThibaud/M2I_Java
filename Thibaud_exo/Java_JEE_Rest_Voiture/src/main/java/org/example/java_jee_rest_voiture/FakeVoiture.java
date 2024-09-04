package org.example.java_jee_rest_voiture;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class FakeVoiture {

    private List<Voiture> voitures;

    public FakeVoiture() {
        voitures = new ArrayList<>(Arrays.asList(
                new Voiture(1, "Golf", new Date(), "Bleu"),
                new Voiture(2, "Clio", new Date(), "Rouge"),
                new Voiture(3, "Peugeot 208", new Date(), "Blanc"),
                new Voiture(4, "BMW Série 3", new Date(), "Noir"),
                new Voiture(5, "Audi A4", new Date(), "Gris")
        ));
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }
    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }
}
