package org.ExoChaise.ExoChaise;

public class Chaise {
    private int nombreDePied;
    private String materiaux;
    private String couleur;


    public Chaise() { }

    /**
     * constructeur de la chaise
     * @param nombreDePied nombre de pied
     */

    public Chaise(int nombreDePied, String materiaux, String couleur) {
        this.nombreDePied = nombreDePied;
        this.materiaux = materiaux;
        this.couleur = couleur;
    }


    public void afficher (){
        System.out.println("Je suis une chaise avec " + this.nombreDePied + " pieds, en " + this.materiaux + " et de couleur " + this.couleur);
    }

}
