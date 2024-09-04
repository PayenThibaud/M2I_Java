package org.example.java_jee_rest_voiture;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Date;
import java.util.List;

@ApplicationScoped
public class VoitureService {

    private FakeVoiture fakeVoiture;

    @Inject
    public VoitureService(FakeVoiture fakeVoiture) {
        this.fakeVoiture = fakeVoiture;
    }

    public Voiture save(int id, String nom, Date dateDeFabrication, String couleur) {
        return new Voiture(id, nom, dateDeFabrication, couleur);
    }

    public Voiture getVoiture(int id) {
        return fakeVoiture.getVoitures().stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Voiture> getAllVoitures() {
        return fakeVoiture.getVoitures();
    }

    public Voiture updateVoiture(int id, String nom, Date dateDeFabrication, String couleur) {
        List<Voiture> voitures = fakeVoiture.getVoitures();
        for (int i = 0; i < voitures.size(); i++) {
            Voiture voiture = voitures.get(i);
            if (voiture.getId() == id) {
                Voiture updatedVoiture = new Voiture(id, nom, dateDeFabrication, couleur);
                voitures.set(i, updatedVoiture);
                return updatedVoiture;
            }
        }
        return null;
    }
}
