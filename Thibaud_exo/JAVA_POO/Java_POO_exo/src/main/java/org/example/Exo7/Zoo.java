package org.example.Exo7;

import org.example.Exo7.Class.Animaux.Animal;
import org.example.Exo7.Class.Animaux.Elephant;
import org.example.Exo7.Class.Animaux.Lion;
import org.example.Exo7.Class.Enclos.EnclosDesElephant;
import org.example.Exo7.Class.Enclos.EnclosDesLions;

public class Zoo {
    public static void main(String[] args) {

        Animal lion1 = new Lion("Simba", 20);
        Animal lion2 = new Lion("Nala", 10);

        Animal elephant1 = new Elephant("Dumbo", 2, 500);
        Animal elephant2 = new Elephant("Babar", 500, 600);

        EnclosDesLions enclosDesLions = new EnclosDesLions(5);
        EnclosDesElephant enclosDesElephant = new EnclosDesElephant(5);

        enclosDesLions.ajouterAnimal(lion1);
        enclosDesLions.ajouterAnimal(lion2);

        enclosDesElephant.ajouterAnimal(elephant1);
        enclosDesElephant.ajouterAnimal(elephant2);

        //test
        enclosDesElephant.ajouterAnimal(lion1);
        enclosDesLions.ajouterAnimal(elephant2);

        enclosDesLions.afficherAnimaux();
        enclosDesElephant.afficherAnimaux();
    }
}
