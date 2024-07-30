package org.example.DemoHeritage;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Animal animal = new Animal(12);
//        System.out.println(animal.getAge());
//        System.out.println("nombre d'animaux :" + Animal.getNbAnimaux());
//
//        Canide canide = new Canide("Hector",13);
//        canide.crier();
//
//        Animal canide_Animal = new Canide("Hector2",14);
//
//        canide_Animal.crier();
//
//        Canide chien_Canide = new Chien("chiuaua","rex",2);
//        chien_Canide.crier();
//        Chien chien =  new Chien("chiuaua","rex",2);
//        chien.aboyer();
//
//        System.out.println(animal);
//        System.out.println(canide_Animal);
//        System.out.println(chien);


        Chien chien = new Chien("chiuaua","rex",2);
        Hyenne hyenne = new Hyenne("hyenne",23);

        Animal chien_animal = chien;
        Canide chien_Canide = chien;

        Canide[] canides = new Canide[2];
        canides[0] = chien;
        canides[1] = hyenne;

        System.out.println(Arrays.toString(canides));

        chien.crier();
        chien_Canide.crier();
        chien_animal.crier();

        for (Canide canide : canides ){
            if(canide instanceof Chien){
                System.out.println("c'est un chien");
                Chien chienRecup = (Chien) canide;
                chienRecup.aboyer();
            }

            if(canide instanceof Hyenne hyenneRecup){
                System.out.println(hyenneRecup);
            }
        }

    }

}
