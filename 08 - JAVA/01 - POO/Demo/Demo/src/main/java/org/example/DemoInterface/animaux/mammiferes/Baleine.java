package org.example.DemoInterface.animaux.mammiferes;

import org.example.DemoInterface.interfaces.Nageant;

public class Baleine extends Mammifere implements Nageant {

    public Baleine(String nom, String couleurFourrure) {
        super(nom, couleurFourrure);
    }

    @Override
    public void accoucher() {
        System.out.println("la baleine accouche");
    }

    @Override
    public void nager() {
        System.out.println("la baleine nage");
    }
}
