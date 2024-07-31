package org.example.DemoInterface.animaux.oiseaux;

import org.example.DemoInterface.animaux.Animal;

public abstract class Oiseau extends Animal {

    protected String couleurPlumage;

    public Oiseau(String nom, String couleurPlumage) {
        super(nom);
        this.couleurPlumage = couleurPlumage;
    }
}
