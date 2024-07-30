package org.example.DemoHeritage;

public abstract class Canide extends Animal{
    protected String nom;

    public Canide(String nom,int age) {
        super(age);
        this.nom = nom;
    }

    @Override
    public void crier (){
        System.out.println("cri du canidé");
    }

    @Override
    public String toString() {
        return  super.toString()+
                "nom : " + nom;
    }
}
