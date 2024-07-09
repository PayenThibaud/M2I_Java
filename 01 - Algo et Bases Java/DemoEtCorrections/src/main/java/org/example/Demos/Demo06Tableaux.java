package org.example.Demos;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Demo06Tableaux {
    public static void main(String[] args) {
        // null est la valeur du vide,
        // elle n'est assignable qu'à des types Objets (remplace la référence)

//        int a = 0;
////        int a2 = null;
//        Integer a2 = null; // classe "Wrapper" de int
//        String s = null;
//        int[] t = null;
//
//        System.out.println(a2);
//        System.out.println(s);
//        System.out.println(t);

        // Tableaux

        // créations et valeurs par défaut
//        int[] tabEntiers = new int[8];
//        for (int item : tabEntiers){
//            System.out.println(item); // 0 => le tableau est préremplis avec les valeurs par défaut
//        }

//        String[] tabChaine = new String[8];
////        for (String item : tabChaine){
//        for (var item : tabChaine){
//            System.out.println(item); // null => le tableau est préremplis avec les valeurs par défaut
//        }

//        char[] tabChar = new char[8];
//        for (var item : tabChar){
//            System.out.println(item); // '\0' => le tableau est préremplis avec les valeurs par défaut
//        }

        // Déclaration d'un tableau
        int[] ages;

        // Allocation de la mémoire pour 5 élements en instanciant le tableau
        ages = new int[5];

        ages[0] = 10;
        ages[1] = 20;
        ages[2] = 30;
        ages[3] = 40;
        ages[4] = 50;


        System.out.println("Element à l'index 0 : " + ages[0]);
        System.out.println("Element à l'index 1 : " + ages[1]);
        System.out.println("Element à l'index 2 : " + ages[2]);
        System.out.println("Element à l'index 3 : " + ages[3]);
        System.out.println("Element à l'index 4 : " + ages[4]);
        //System.out.println("Element à l'index 4 : " + ages[5]);  // ArrayIndexOutOfBoundsException => en dehors du tableau

        System.out.println("Taille du tableau : " + ages.length);

        System.out.println(Arrays.toString(ages));

        for (int i = 0; i < ages.length; i++) {
            System.out.println(ages[i]);
        }

        for(int entier : ages){
            System.out.println(entier);
        }

//        Scanner[] scanners;
//        Random[] randoms;
//        boolean[] bools;


        // Syntaxe pour declarer et allouer directement le tableau
        String[] tableauChaine = {"Bonjour","toto","tata"};
//        String[] tableauChaine = {
//                "Bonjour",
//                "toto",
//                "tata"
//        };

        System.out.println(tableauChaine.length);
        System.out.println(Arrays.toString(tableauChaine));

        // Tableaux multi-dimensionnels
        System.out.println("##### Tableaux multi-dimensionnels ##### ");

//        int[][] tab2Dimensions = new int[2][3];
//        int[][] tab2Dimensions = {new int[3], new int[3]};

        String[][] titresNoms = {
                {"Mr","Mme","Mlle"},
                {"Dupont","Legrand"}
        };


        System.out.println(titresNoms[0][0]+" "+titresNoms[1][0]); // Mr Dupont
        System.out.println(titresNoms[0][2]+" "+titresNoms[1][1]); // Mlle Legrand


        // Taille du tableau
        System.out.println(titresNoms.length); // 2
        System.out.println(titresNoms[0].length); // 3
        System.out.println(titresNoms[1].length); // 2
    }
}
