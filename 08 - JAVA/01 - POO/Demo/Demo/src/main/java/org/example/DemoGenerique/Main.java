package org.example.DemoGenerique;

import org.example.DemoGenerique.Interface.Enclot;
import org.example.DemoGenerique.animaux.Elephant;
import org.example.DemoGenerique.animaux.Lion;

public class Main {
    public static void main(String[] args) {
        Enclot<Elephant> enclotElephant = new Enclot<>(new Elephant[20]);
        Enclot<Lion> enclotLion = new Enclot<>(new Lion[20]);

        Lion lion = new Lion("Simba",5);
        Elephant elephant = new Elephant("Dumbo",2,1500);

        enclotElephant.ajouterAnimal(elephant);
        enclotLion.ajouterAnimal(lion);

        enclotElephant.afficherAnimaux();
        enclotLion.afficherAnimaux();
    }
}
