package org.example.Exo7.Class.Animaux;

public class Lion extends Animal {
    private String nom;
    private int age;

    public Lion(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    @Override
    public void manger() {
        System.out.println(nom + " le lion mange.");
    }

    @Override
    public void dormir() {
        System.out.println(nom + " le lion dort.");
    }

    @Override
    public void faireDuBruit() {
        System.out.println(nom + " le lion fait du bruit.");
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }
}
