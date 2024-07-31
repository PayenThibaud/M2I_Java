package org.example.DemoInterface.animaux.oiseaux;

import org.example.DemoInterface.interfaces.Volant;

public class Pigeon extends Oiseau implements Volant {
    public Pigeon(String nom, String couleurPlumage) {
        super(nom, couleurPlumage);
    }

    @Override
    public void decoller() {
        System.out.println("le pigeon décole");
    }

    @Override
    public void atterrir() {
        System.out.println("le pigeon atterri");
    }
}
