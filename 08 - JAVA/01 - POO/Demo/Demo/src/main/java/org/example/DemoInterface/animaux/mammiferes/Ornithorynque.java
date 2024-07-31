package org.example.DemoInterface.animaux.mammiferes;

import org.example.DemoInterface.interfaces.Nageant;

public class Ornithorynque extends Mammifere implements Nageant {

    public Ornithorynque(String nom, String couleurFourrure) {
        super(nom, couleurFourrure);
    }

    @Override
    public void accoucher() {
        System.out.println("l'ornithorynque pond");
    }

    @Override
    public void nager() {
        System.out.println("l'ornithorynque nage");
    }
}
