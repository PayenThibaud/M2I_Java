package org.example.ExoRecette;

public class Commentaire {
    private String description;

    public Commentaire(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return description;
    }
}