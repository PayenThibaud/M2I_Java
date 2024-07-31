package org.example.DemoInterface.animaux.oiseaux;

import org.example.DemoInterface.interfaces.Nageant;
import org.example.DemoInterface.interfaces.Volant;

public class Canard extends Oiseau implements Nageant, Volant {
    public Canard(String nom, String couleurPlumage) {
        super(nom, couleurPlumage);
    }

    @Override
    public void nager() {
        System.out.println("Le canard nage");
    }

    @Override
    public void decoller() {
        System.out.println("Le canard decolle");
    }

    @Override
    public void atterrir() {
        System.out.println("Le canard atterri");
    }
}
