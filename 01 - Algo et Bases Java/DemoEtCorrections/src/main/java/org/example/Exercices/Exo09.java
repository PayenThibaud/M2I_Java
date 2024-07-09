package org.example.Exercices;

import java.util.Scanner;

public class Exo09 {
    public static void main(String[] args) {
//        Saisir la longueur d'un côté : 5
        Scanner scanner = new Scanner(System.in);
        System.out.print("Saisir la longueur d'un côté :");
        double cote = scanner.nextDouble();
//        Le périmètre du carré est de : 20cm
        System.out.println("Le périmètre du carré est de : " + (cote * 4) + "cm");
//        L'aire du carré est de : 25cm carré
        System.out.println("Le périmètre du carré est de : " + (cote * cote) + "cm");
        System.out.println("Le périmètre du carré est de : " + Math.pow(cote, 2) + "cm");

    }
}
