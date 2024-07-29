package org.example.Exercice1;

public class Chaise {

    private int nombreDePieds = 4;
    private String materiaux = "Bois";
    private String couleur = "Jaune";


    public Chaise (){
    }
    public Chaise (int nombreDePieds, String materiaux, String couleur){
        this.nombreDePieds = nombreDePieds;
        this.materiaux = materiaux;
        this.couleur = couleur;
    }

    public int getNombreDePieds() {
        return nombreDePieds;
    }

    public void setNombreDePieds (int nombreDePieds){
        this.nombreDePieds = nombreDePieds;
    }

    public String getMateriaux (){
        return this.materiaux;
    }

    public void setMateriaux (String materiaux){
        this.materiaux = materiaux;
    }

    public String getCouleur (){
        return couleur;
    }

    public void setCouleur(String couleur){
        this.couleur = couleur;
    }

    public void afficher (){
        System.out.println("Je suis une Chaise; avec "+this.nombreDePieds+" pieds, je suis en "+this.materiaux+" ,je suis de couleur "+this.couleur);
    }

    @Override
    public String toString (){
        return "Je suis une Chaise; avec "+this.nombreDePieds+" pieds, je suis en "+this.materiaux+" ,je suis de couleur "+this.couleur;
    }
}
