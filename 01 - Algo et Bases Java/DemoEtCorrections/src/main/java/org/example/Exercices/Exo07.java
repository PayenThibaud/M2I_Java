package org.example.Exercices;

import java.util.Scanner;

public class Exo07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir le rayon :");
        int rayon = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Saisir la hauteur :");
        int hauteur = scanner.nextInt();
        scanner.nextLine();

//        double volume = (1.0 / (double) 3) * Math.PI * Math.pow(rayon, 2) * hauteur;
        double volume = 1. / 3 * Math.PI * Math.pow(rayon, 2) * hauteur;

        System.out.printf("Le volume du cône est : %.2f cm3", volume);

        scanner.close();
    }
}
