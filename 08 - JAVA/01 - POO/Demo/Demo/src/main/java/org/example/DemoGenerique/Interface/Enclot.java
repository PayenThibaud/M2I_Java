package org.example.DemoGenerique.Interface;

import java.util.Arrays;

public class Enclot <T> {

    private T[] animaux;

    public Enclot(T[] animaux) {
        this.animaux = animaux;
    }

    public void ajouterAnimal(T animal){
        for (int i = 0; i<animaux.length-1;i++){
            if(animaux[i] == null){
                animaux[i]=animal;
                return;
            }
        }
    }
     public void afficherAnimaux(){
        for (T element : animaux){
            if(element == null){
                return;
            }
            System.out.println(element);
        }
    }
}
