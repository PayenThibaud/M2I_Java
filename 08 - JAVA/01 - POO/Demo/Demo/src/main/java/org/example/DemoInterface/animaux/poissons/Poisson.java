package org.example.DemoInterface.animaux.poissons;

import org.example.DemoInterface.animaux.Animal;

public abstract class Poisson extends Animal {

    protected String couleurEcailles;

    public Poisson(String nom,String couleurEcailles) {
        super(nom);
        this.couleurEcailles = couleurEcailles;
    }
}
