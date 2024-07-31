package org.example.ExoPlante;

public class Plante {
    protected String nom;
    protected int hauteur;
    protected String couleur;

    public Plante(String nom, int hauteur, String couleur) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Plante{nom '" + nom + "', hauteur " + hauteur + ", couleur '" + couleur + "'}";
    }
}
