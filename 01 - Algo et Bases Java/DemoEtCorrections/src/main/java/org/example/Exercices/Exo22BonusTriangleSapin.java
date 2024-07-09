package org.example.Exercices;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Exo22BonusTriangleSapin {
    public static void main(String[] args) throws InterruptedException {

//        Scanner scanner = new Scanner(System.in);
//
//        // TRIANGLE
//        System.out.println("Saisir la hauteur du triangle : ");
//        int hauteur = Integer.parseInt(scanner.nextLine());
//
//
//        // 1 - avec incrementation et decrementation
//        int nbEspaces = hauteur - 1;
//        int nbEtoiles = 1;
//
//        for (int ligne = 1; ligne <= hauteur; ligne++)
//        {
//            String espaces = " ".repeat(nbEspaces); // sert à répèter des String
//            String etoiles = "*".repeat(nbEtoiles);
//            System.out.println(espaces + etoiles);
//            nbEspaces--;
//            nbEtoiles += 2;
//        }
//
//        // 2 - avec calcul du nombre de caractères
//        for (int ligne = 1; ligne <= hauteur; ligne++)
//        {
//            String espaces = " ".repeat(hauteur - ligne);
//            String etoiles = "*".repeat(2 * ligne - 1);
//            System.out.println(espaces + etoiles);
//        }
//
//        // 3 - avec des boucles imbriquées et print()
//        for (int ligne = 1; ligne <= hauteur; ligne++)
//        {
//            for (int espaces = 1; espaces <= hauteur - ligne; espaces++)
//                System.out.print(" ");
//            for (int etoiles = 1; etoiles <= 2 * ligne - 1; etoiles++)
//                System.out.print("*");
//            System.out.println();
//        }
//
//        // 4 - avec des chaines interpollées
//        for (int ligne = 1; ligne <= hauteur; ligne++)
//        {
////            int tailleLigne = (hauteur - ligne + 2 * ligne - 1);
//            int tailleLigne = hauteur + ligne - 1;
//            String etoiles = "*".repeat(2 * ligne - 1);
//            System.out.printf("%" + tailleLigne + "s\n" , etoiles);
//        }


//        // SAPIN
//
//        String green = "\u001B[32m";   // green
//        String yellow = "\u001B[33m";   // yellow
//        String darkRed = "\u001B[31m";   // darkRed
//        String[] ballColors =  {
//                "\u001B[91m",   // red
//                "\u001B[33m",   // yellow
//                "\u001B[34m",   // blue
//                "\u001B[35m",   // purple
//                "\u001B[36m"    // cyan
//        };
//
//        Random random = new Random();
//
//        System.out.println("Saisir la hauteur du sapin : ");
//        int hauteur = Integer.parseInt(scanner.nextLine());
//        System.out.println("Saisir la hauteur du tronc : ");
//        int tronc = Integer.parseInt(scanner.nextLine());
//
//
//        while (true) // boucle des sapins
//        {
//            for (int ligne = 1; ligne <= hauteur; ligne++) // boucle des lignes du sapin
//            {
//                for (int espaces = 1; espaces <= hauteur - ligne; espaces++) // boucle des espaces au début des lignes
//                    System.out.print(" ");
//
//                if (ligne == 1) // pointe du sapin
//                    System.out.print(yellow + "A");
//                else
//                    for (int etoiles = 1; etoiles <= 2 * ligne - 1; etoiles++) // boucle des boules et des étoiles
//                    {
//                        String symb;
////                        if (random.nextInt(1, 8) > 3)
//                        if (random.nextDouble() > 0.33)
//                            symb = green + "*";
//                        else
//                            symb = ballColors[random.nextInt(ballColors.length)] + "o";
//                        System.out.print(symb);
//                    }
//                System.out.println();
//            }
//
//            String espacesTronc = darkRed + (" ".repeat( hauteur - 2));
//            for (int i = 0; i < tronc; i++)
//                System.out.println(espacesTronc + "| |");
//
//            Thread.sleep(500);
//        }
//        //System.out.println("\u001B[0m"); //remettre la couleur de base

        // SAPIN (en un seul print avec le StringBuilder => plus optimisé que la concatenation ou les prints)

//        String green = "\u001B[32m";   // green
//        String yellow = "\u001B[33m";   // yellow
//        String darkRed = "\u001B[31m";   // darkRed
//        String[] ballColors = {
//                "\u001B[91m",   // red
//                "\u001B[33m",   // yellow
//                "\u001B[34m",   // blue
//                "\u001B[35m",   // purple
//                "\u001B[36m"    // cyan
//        };
//
//        Random random = new Random();
//
//        System.out.println("Saisir la hauteur du sapin : ");
//        int hauteur = Integer.parseInt(scanner.nextLine());
//        System.out.println("Saisir la hauteur du tronc : ");
//        int tailleTronc = Integer.parseInt(scanner.nextLine());
//
//        StringBuilder sapinFinal = new StringBuilder();
//
//        while (true){ // boucle des sapins
//            for (int ligne = 1; ligne <= hauteur; ligne++){ // boucle des lignes du sapin
//                sapinFinal.append(" ".repeat(hauteur - ligne));// espaces au début des lignes
//
//                if (ligne == 1) // pointe du sapin
//                    sapinFinal.append(yellow).append("A");
//                else
//                    for (int etoiles = 1; etoiles <= 2 * ligne - 1; etoiles++) // boucle des boules et des étoiles
//                        sapinFinal.append(random.nextDouble() > 0.33 ? green + "*"
//                                : ballColors[random.nextInt(ballColors.length)] + "o");
//                sapinFinal.append('\n');
//            }
//
//            String espacesTronc = darkRed + (" ".repeat(hauteur - 2));
//
//            sapinFinal.append((espacesTronc + "| |\n").repeat(tailleTronc));
//
//            System.out.println(sapinFinal);
//
//            Thread.sleep(1000);
//        }
//        //System.out.println("\u001B[90m"); //remettre la couleur de base



        // Petit cadeau : voici un générateur d'arc-en-ciel !
        String[] colors =  {
                "\u001B[101m",  //	Bright Red
                "\u001B[103m",  //	Bright Yellow
                "\u001B[102m",  //	Bright Green
                "\u001B[106m",  //	Bright Cyan
                "\u001B[104m",  //	Bright Blue
                "\u001B[105m",  //	Bright Magenta
        };
        String grey = "\u001B[0m";
        int tailleMorceau = 16; //taille d'un morceau d'arc-en-ciel
        String charMorceau =  "\u001B[37m"+ " "; //  caractère utilisé dans les morceaux écrit en blanc
        double vitesse = 0.13; // vitesse à laquelle l'arc-en-ciel bouge en amplitude
        double decalage = 5;  // décalage sur la gauche en nb espaces
        double amplitude = 50; // amplitude en nb espaces
        int actualisationMillis = 100; // temps d'attente entre chaque prints

        String morceau = "%" + tailleMorceau + "s"; // chaine interpolée des morceaux d'arc en ciel
        //construction de la partie colorée de la ligne (chaine interpolée)
        StringBuilder ligneArcEnCiel = new StringBuilder();
        for (String color : colors)
            ligneArcEnCiel.append(color).append(morceau);
        ligneArcEnCiel.append(grey).append("\n");
        // résultat => "\u001B[101m%16s\u001B[103m%16s\u001B[102m%16s\u001B[106m%16s\u001B[104m%16s\u001B[105m%16s\n"

        int i = 0;
        while (true) {
            int nbEspaces = (int) Math.round((Math.cos(i*vitesse)+1) * (amplitude/2) + decalage);

            String ligne = grey + " ".repeat(nbEspaces) + ligneArcEnCiel;

            System.out.printf(ligne, Collections.nCopies(colors.length, charMorceau.repeat(tailleMorceau)).toArray());

            i++;
            Thread.sleep(actualisationMillis);
        }
    }
}
