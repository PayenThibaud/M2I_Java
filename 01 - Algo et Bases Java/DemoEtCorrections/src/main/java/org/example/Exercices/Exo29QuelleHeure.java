package org.example.Exercices;

public class Exo29QuelleHeure {

    public static void quelleHeure(String heure){
        System.out.println("Il est " + heure);
    }

    public static void quelleHeure(){
//        System.out.println("Il est 12h00");
        quelleHeure("12H00");
    }

    public static void main(String[] args) {
        quelleHeure("14h00");
        quelleHeure();
    }
}
