package org.example.Exo7.Class.Enclos;

import org.example.Exo7.Class.Animaux.Animal;
import org.example.Exo7.Class.Animaux.Elephant;
import org.example.Exo7.Interface.Enclos;

public class EnclosDesElephant implements Enclos {
    private Elephant[] elephants;
    private int count;

    public EnclosDesElephant(int taille) {
        elephants = new Elephant[taille];
        count = 0;
    }

    @Override
    public void ajouterAnimal(Animal animal) {
        if (animal instanceof Elephant) {
            if (count < elephants.length) {
                elephants[count] = (Elephant) animal;
                count++;
                System.out.println(((Elephant)animal).getNom() + " elephant ajouter.");
            } else {
                System.out.println("Pu de place");
            }
        } else {
            System.out.println("Ce n est pas un elephant !!!");
        }
    }

    @Override
    public void afficherAnimaux() {
        System.out.println("Enclos des elephants :");
        for (int i = 0; i < count; i++) {
            System.out.println("Nom : " + elephants[i].getNom() + ", Age : " + elephants[i].getAge() + ", Poids : " + elephants[i].getPoids());
        }
    }
}