package org.example.DemoInterface.animaux;

public abstract class Animal {
    protected String nom;

    public Animal(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "je suis un.e : "+ super.getClass().getSimpleName()
                + "("+ super.getClass().getSuperclass().getSimpleName() +")";
    }
}
