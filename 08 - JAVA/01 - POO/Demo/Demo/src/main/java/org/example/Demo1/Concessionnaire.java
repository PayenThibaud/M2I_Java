package org.example.Demo1;

import java.util.Arrays;

public class Concessionnaire {

    private Voiture[] voitures ;

    public Concessionnaire (){
        voitures = new Voiture[3];
    }

    public void addVoiture (Voiture voiture){
         voitures[0] = voiture;
    }

    public void addVoiture (String model,String color,int reservoir,int autonomie){
        Voiture voiture = new Voiture(model,color,reservoir,autonomie);
        voitures[1] = voiture;
    }

    public void show (){
        System.out.println(Arrays.toString(voitures));
    }

}
