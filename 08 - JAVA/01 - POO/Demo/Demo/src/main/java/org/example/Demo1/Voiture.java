package org.example.Demo1;

public class Voiture {
    public String model;
    public String couleur;
    private int reservoir;
    private int autonomie;

    public Voiture() { }
    public Voiture(String model, String couleur, int reservoir, int autonomie) {
        this.model = model;
        this.couleur = couleur;
        this.reservoir = reservoir;
        this.autonomie = autonomie;
    }

    public void afficher (){
        System.out.println("Notre première voiture est une " + this.model + " de couleur " + this.couleur);
        System.out.println("Elle a un réservoir de " + this.reservoir + " litres pour une autonomie de " + this.autonomie + " km.");
    }
}
