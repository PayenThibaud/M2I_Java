package org.example.DemoHeritage;

public abstract class Animal {
    protected int age;
    private static int nbAnimaux;

    public Animal (int age){
        nbAnimaux++;
        this.age = age;
    }

    public abstract void crier();

    public int getAge (){
        return age;
    }

    public static int getNbAnimaux (){
        return nbAnimaux;
    }

    @Override
    public String toString() {
        return  super.getClass().getSimpleName() +
                "\n Methode to string du parent (object) "+ super.toString() +
                ", age=" + age;
    }
}
