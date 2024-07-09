package org.example.Demos;

import java.util.Scanner;

public class Demo05StructuresIteratives {
    public static void main(String[] args) {
        // TANT QUE / WHILE

//        int compteur = 1; // attention à l'endroit où commence la variable pour connaitre les iterations
//
//        while (compteur < 11){
//            System.out.println("Compteur vaut :" + compteur);
//            compteur++;
////            int a = 0; // variable locale à l'itération
////            a++;
////            System.out.println("a = " + a);
//        }
//
//        System.out.println("Après la boucle");
//        System.out.println("Compteur vaut :" + compteur);
//

//        while (true){
//            System.out.println("HAHA");
//        }

//        int compteur = 1;
//
//        while (compteur < 11){
//            if(compteur == 8){
//                System.out.println("Autre chose");
//                break; // sortir de la boucle
//            }
//            compteur++;
//            if(compteur == 3){
//                System.out.println("C'est trois...");
//                continue; // sort de l'itération (on continue vers l'itération suivante après revérification de la condition)
//            }
//            System.out.println("Compteur vaut :" + compteur);
//        }
//
//        System.out.println("Après la boucle");


//        Scanner scanner = new Scanner(System.in);
//        int saisie;
//
//        do {
//            System.out.print("Saisir 3 : ");
//            saisie = scanner.nextInt();
//        } while (saisie != 3);
//
//        System.out.println("Tu as enfin saisi 3, bravo ! (c'était pas si compliqué...)");


//        Scanner scanner = new Scanner(System.in);
//        int saisie;
//
//        //while (true) {
//        do {
//            System.out.print("Saisir 3 : ");
//            saisie = scanner.nextInt();
//            if (saisie == 3)
//                break;
//        } while (true);
//
//        System.out.println("Tu as enfin saisi 3, bravo ! (c'était pas si compliqué...)");


        // FOR
        //for (<instruction début>; <condition de sortie>; <instruction inter-boucle>)
//        for (int i = 0; i < 10; i++) { // i a une portée inter-iterations
//            System.out.println("i : " + i);
//        }
//
//        System.out.println("Après la boucle");
//
//        // équivalent en while
//
//        int i = 0; // portée englobante
//        while (i < 10) {
//            System.out.println("i : " + i);
//            i++;
//        }


        // boucles infinies => condition de sortie toujour vraie
//        for (int j = 0; true; j++) {
//            System.out.println("j : " + j);
//        }
//        for (int j = 0; j>=0; j++) {
//            System.out.println("j : " + j);
//        }
//        for (int j = 0; j<10; j--) {
//            System.out.println("j : " + j);
//        }


//        for (int cpt = 0; cpt < 10;cpt++){
//            if (cpt == 3) continue;
//            if (cpt == 8) break;
//            System.out.println(cpt);
//        }

        // FOREACH / POUR CHAQUE ELEMENT DANS L'ENSEMBLE
        String alphabet = "abcdeffggehytllmopqrsttucvwxyz";

        for(char lettre : alphabet.toCharArray()){
            System.out.println("Ma lettre actuelle : \"" + lettre + "\".");
            //                  Ma lettre actuelle : "a"
        }



        // \' \0 \" \\

        System.out.println("\"");
        System.out.println("\\");

        System.out.println('a');
        System.out.println('\\');
        System.out.println('\'');

        System.out.println(""); // chaine vide
        System.out.println('\0'); // caractère vide

        System.out.println('\0' + '\0' + "" + "\0\0");



        // var / typage implicite

        var entier = 0;
        int entier2 = 0;

        var chaine = "abc";

        var scanner = new Scanner(System.in);

        var bool = 1<2 || true;
    }
}
