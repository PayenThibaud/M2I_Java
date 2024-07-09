package org.example.Exercices;

import java.util.Scanner;

public class Exo21SuiteEntiersConsecutifs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Les suites chaînées de nombres ---\n");
        System.out.print("Merci de saisir un nombre : ");
        int nombreSaisi = Integer.parseInt(scanner.nextLine());


        System.out.println("Les chaînes possibles sont :");

        int midNumber = nombreSaisi / 2 + 1; // on ne va pas plus loin que la moitié + 1 pour optimiser

        for (int debutChaine = 1; debutChaine <= midNumber; debutChaine++){
            int sommeEntiers = 0;
            boolean chaineValide = false; // flag indiquant si la chaine testée est valide
            int finChaine = 0; // nombre fin de la chaine testée

            for (int j = debutChaine; j <= midNumber; j++){ // test de la chaine
                sommeEntiers += j; // on augmente de la nouvelle valeur
                if (sommeEntiers == nombreSaisi){ // si on a atteint l'objectif
                    chaineValide = true;
                    finChaine = j;
                }
                if (sommeEntiers >= nombreSaisi) // si on dépasse
                    break; // pour optimiser en faisant moins de boucles
            }

            if (chaineValide){ // affichage de la chaine si valide
                System.out.print(nombreSaisi + " = " + debutChaine);
                for (int j = debutChaine + 1; j <= finChaine; j++){
                    System.out.print("+" + j);
                }
                System.out.println();
            }
        }
        
        

//        // Version alternative
//        System.out.println("--- Les suites chaînées de nombres ---\n");
//
//        System.out.print("Merce de saisir un nombre : ");
//        int number = Integer.parseInt(scanner.nextLine());
//
//        int midNumber = number / 2 + 1;
//
//        System.out.println("Les chaînes possibles sont :");
//        for (int debut = 1; debut <= midNumber; debut++)
//        {
//            int sum = 0;
//            int next = debut;
//
//            while (sum < number) // tant qu'on n'a pas atteint ou dépassé l'objectif
//                sum += next++; // on passe au nombre suivant et on augmente la somme
//
//            if (sum == number){ // si l'objectif est atteint pile-poil
//                System.out.print(number + " = " + debut);
//                for (int j = debut + 1; j <= next - 1; j++)
//                    System.out.print("+" + j);
//                System.out.println();
//            }
//        }



//        // Version plus optimisée, avec une logique différente et qui prend en compte les nombres négatifs
//        System.out.println("--- Les suites chaînées de nombres ---\n");
//        System.out.print("Merce de saisir un nombre : ");
//        int number = Integer.parseInt(scanner.nextLine());
//
//        System.out.println("Les chaînes possibles sont :");
//
//        for (double diviseur = 2; diviseur <= number; diviseur++){
//            double mid = number / diviseur;
//
//            if (mid % 0.5 == 0){
//                int debut = (int)(mid - diviseur / 2) + 1;
//
//                if (debut < 1) break; // décommenter pour les négatifs
//
//                int fin = (int)(mid + diviseur / 2);
//
//                System.out.print(number + " = " + debut);
//                for (int j = debut + 1; j <= fin; j++){
//                    System.out.print("+" + j);
//                }
//                System.out.println();
//            }
//        }
    }
}
