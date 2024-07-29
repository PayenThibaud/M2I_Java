package org.example.Demo1;

public class Voiture {
    private String model;
    private String couleur;
    private int reservoir;
    private int autonomie;
    private boolean demaree;

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

    public void demarrer (){
        if(demaree){
            System.out.println("moteur deja demaré");
        }else{
            System.out.println("le moteur demare");
            demaree = true;
        }
    }
    public String getModel (){
        return this.model;
    }

    public void setModel (String model){
        this.model = model;
    }
}
