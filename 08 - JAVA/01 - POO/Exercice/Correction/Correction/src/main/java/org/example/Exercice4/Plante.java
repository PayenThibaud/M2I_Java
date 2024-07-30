package org.example.Exercice4;

public class Plante {
    protected String nom;
    protected float hauteur;
    protected String couleurFeuille;

    public Plante(String nom, float hauteur, String couleurFeuille) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.couleurFeuille = couleurFeuille;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    public String getCouleurFeuille() {
        return couleurFeuille;
    }

    public void setCouleurFeuille(String couleurFeuille) {
        this.couleurFeuille = couleurFeuille;
    }

    public void affichage (){
        System.out.println(super.getClass().getSimpleName() + ", nom : "+nom+", hauteur : "+hauteur+", couleur des feuilles : "+couleurFeuille);
    }
}
