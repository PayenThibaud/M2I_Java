package org.example.DemoInterface.animaux.poissons;

import org.example.DemoInterface.interfaces.Nageant;

public class Thon extends Poisson implements Nageant {
    public Thon(String nom, String couleurEcailles) {
        super(nom, couleurEcailles);
    }

    @Override
    public void nager() {
        System.out.println("le thon nage");
    }
}
