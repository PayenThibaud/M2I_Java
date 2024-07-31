package org.example.DemoInterface.animaux.mammiferes;


import org.example.DemoInterface.animaux.Animal;

public abstract class Mammifere extends Animal {

    protected String couleurFourrure;

    public Mammifere(String nom,String couleurFourrure) {
        super(nom);
        this.couleurFourrure = couleurFourrure;
    }

    public abstract void accoucher();
}
