package org.example.Exercice3;

public class WaterTank {

    private float poidVide;
    private int capaciteTotal;
    /**
     * remplissage est le nombre de litre present dans ma citerne
     */
    private int remplissage = 0;

    public WaterTank (float poidVide,int capaciteTotal){
        this.poidVide = poidVide;
        this.capaciteTotal = capaciteTotal;
    }
    /**
     * @param remplissage est le nombre de litre present dans ma citerne
     */
    public WaterTank (float poidVide,int capaciteTotal,int remplissage){
        this(poidVide,capaciteTotal);
        this.remplissage = remplissage;
    }

    public float poidTotal (){
        return poidVide + remplissage;
    }




}
