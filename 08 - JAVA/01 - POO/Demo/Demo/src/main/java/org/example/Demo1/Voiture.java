package org.example.Demo1;


/**
 * Classe voiture
 *
 */
public class Voiture {
    private String model;
    private String couleur;
    private int reservoir;
    private int autonomie;
    private boolean demaree;

    private static int nombreVoiture = 0;

    public Voiture() {
        nombreVoiture++;
    }

    /**
     * constructeur de la voiture
     * @param model model de la voiture
     * @param couleur couleur de la voiture
     * @param reservoir contenance du reservoire de la voiture
     * @param autonomie autonomie de la voiture
     */

    // Mon constructeur voiture
    public Voiture(String model, String couleur, int reservoir, int autonomie) {
        this(reservoir,autonomie);
        this.model = model;
        this.couleur = couleur;
    }

    public Voiture( int reservoir, int autonomie){
        this();
        this.reservoir = reservoir;
        this.autonomie = autonomie;
    }


    /**
     * methode d'affichage de la voiture
     */
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

    public static int getNombreVoiture (){
      return nombreVoiture;
    }
    public String getModel (){
        return this.model;
    }

    public void setModel (String model){
        this.model = model;
    }
}
