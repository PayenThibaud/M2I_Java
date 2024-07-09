package org.example.Exercices;

import java.util.Scanner;

public class Exo10 {
    public static void main(String[] args) {
        int nbCopies;
        double prixAPayer;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer le nombre de photocopies :");
        nbCopies = scanner.nextInt();

        System.out.println("Vous avez demandé " + nbCopies + " photocopies.");

//        if (nbCopies < 10){
//            // sout calcul du prix 0.5
//        } else {
//            if (nbCopies <=20){
//                // sout calcul du prix 0.4
//            } else {
//                // sout calcul du prix 0.4
//            }
//        }

        double coeff = 0.3; // 0.5 ou 0.4 ou 0.3

        if (nbCopies < 10) {
            coeff = 0.5;
            //prixAPayer = nbCopies * 0.5;
        } else if (nbCopies <= 20) {
            coeff = 0.4;
        } /*else {
            coeff = 0.3;
        }*/

        prixAPayer = nbCopies * coeff;


        System.out.println("Pour " + nbCopies + " le montant à paye est de : " + prixAPayer);

    }
}
