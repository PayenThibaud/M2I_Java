package org.example.Exercices;

import java.util.Scanner;

public class Exo14 {
    public static void main(String[] args) {
        System.out.println("Exercice 9");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez donner votre taille (en cm) :");
        int taille = scanner.nextInt();
        System.out.println("Veuillez donner votre poids (en kg) : ");
        int poids = scanner.nextInt();

        if ((taille >= 145 && taille < 172 && poids >= 43 && poids < 48)
                || (taille >= 145 && taille < 169 && poids >= 48 && poids < 54)
                || (taille >= 145 && taille < 166 && poids >= 54 && poids < 60)
                || (taille >= 145 && taille < 163 && poids >= 60 && poids < 66)) {
            System.out.println("Vous êtes de taille 1");
        } else if ((taille >= 169 && taille < 183 && poids >= 48 && poids < 54)
                || (taille >= 166 && taille < 178 && poids >= 54 && poids < 60)
                || (taille >= 163 && taille < 175 && poids >= 60 && poids < 66)
                || (taille >= 160 && taille < 172 && poids >= 66 && poids < 72)) {
            System.out.println("Vous êtes de taille 2");
        } else if ((taille >= 178 && taille < 187 && poids >= 54 && poids < 60)
                || (taille >= 175 && taille < 187 && poids >= 60 && poids < 66)
                || (taille >= 172 && taille < 187 && poids >= 66 && poids < 72)
                || (taille >= 163 && taille < 187 && poids >= 72 && poids < 78)) {
            System.out.println("Vous êtes de taille 3");
        } else {
            System.out.println("Nous n'avons pas votre taille...");
        }

    }
}
