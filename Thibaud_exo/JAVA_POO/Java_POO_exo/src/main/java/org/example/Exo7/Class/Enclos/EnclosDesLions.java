package org.example.Exo7.Class.Enclos;

import org.example.Exo7.Class.Animaux.Animal;
import org.example.Exo7.Class.Animaux.Lion;
import org.example.Exo7.Interface.Enclos;

public class EnclosDesLions implements Enclos {
    private Lion[] lions;
    private int count;

    public EnclosDesLions(int taille) {
        lions = new Lion[taille];
        count = 0;
    }

    @Override
    public void ajouterAnimal(Animal animal) {
        if (animal instanceof Lion) {
            if (count < lions.length) {
                lions[count] = (Lion) animal;
                count++;
                System.out.println(((Lion)animal).getNom() + " Lion ajouter");
            } else {
                System.out.println("Pu de place");
            }
        } else {
            System.out.println("Ce n est pas un lion !!!");
        }
    }

    @Override
    public void afficherAnimaux() {
        System.out.println("Enclos des lions :");
        for (int i = 0; i < count; i++) {
            System.out.println("Nom : " + lions[i].getNom() + ", Age : " + lions[i].getAge());
        }
    }
}