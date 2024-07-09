package org.example.Exercices;

import java.util.Scanner;

public class Exo04 {
    public static void main(String[] args) {
//        int a, b;
//        System.out.println("entrer le nombre ");
//        Scanner scanner = new Scanner(System.in);
//        a = scanner.nextInt();
//        b = 2*a;
//        System.out.println("le double de " + a + " est : " + b);



        String nom, prenom, nomComplet;
        Scanner scanner = new Scanner(System.in);

        System.out.println("entrez votre nom");
        nom = scanner.nextLine();
        System.out.println("entrez votre prénom");
        prenom = scanner.nextLine();
        nomComplet = nom + prenom;
        System.out.println("Votre nom complet est : " + nomComplet);
    }
}
