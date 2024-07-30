package org.example.DemoHeritage;

public class Chien extends Canide{
    private String race;
    public Chien(String race,String nom, int age) {
        super(nom, age);
        this.race = race;
    }

    @Override
    public void crier(){
        System.out.println("le chien abboie !");
    }

    public void aboyer (){
        crier();
        System.out.println("aboie depuis aboyer");
    }

    @Override
    public String toString() {
        return "Chien{" +
                "race='" + race + '\'' +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }
}
