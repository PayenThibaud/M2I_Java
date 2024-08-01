package org.example.Exo7.Class.Animaux;

public class Elephant extends Animal {
    private String nom;
    private int age;
    private int poids;

    public Elephant(String nom, int age, int poids) {
        this.nom = nom;
        this.age = age;
        this.poids = poids;
    }

    @Override
    public void manger() {
        System.out.println(nom + " l'éléphant mange.");
    }

    @Override
    public void dormir() {
        System.out.println(nom + " l'éléphant dort.");
    }

    @Override
    public void faireDuBruit() {
        System.out.println(nom + " l'éléphant fait du bruit.");
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public int getPoids() {
        return poids;
    }
}