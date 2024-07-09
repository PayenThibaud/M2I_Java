package org.example.Exercices;

import java.util.Arrays;

public class Exo26TabEgaux {
    public static void main(String[] args) {
        int[] tableau1 = {1, 4, 2, 3};
        int[] tableau2 = {1, 4, 2, 3};
//        boolean identique = true;
//
//        if (tableau1.length != tableau2.length) {
//            identique = false;
//        } else {
//            for (int i = 0; i < tableau1.length; i++) {
//                if (tableau1[i] != tableau2[i]) {
//                    identique = false;
//                    break;
//                }
//            }
//        }
//
//        System.out.println("Tableau 1 : "+ Arrays.toString(tableau1));
//        System.out.println("Tableau 2 : "+ Arrays.toString(tableau2));
//
//        if (identique) {
//            System.out.println("les tableaux sont égaux");
//        } else {
//            System.out.println("les tableaux ne sont pas égaux");
//        }
//
//        String identiqueString = identique ? "sont" : "ne sont pas";
//        System.out.println("les tableaux " + identiqueString + " égaux");


        String identiqueString = Arrays.compare(tableau1, tableau2) == 0 ? "sont" : "ne sont pas";
        System.out.println("les tableaux " + identiqueString + " égaux");
    }
}
