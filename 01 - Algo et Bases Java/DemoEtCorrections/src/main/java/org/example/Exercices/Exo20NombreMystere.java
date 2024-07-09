package org.example.Exercices;

import java.util.Random;
import java.util.Scanner;

public class Exo20NombreMystere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

        int nombreMystere = r.nextInt(100);
//        int nombreMystere = r.nextInt(50, 100);
        int nombreUser;
        int tentative = 0;

        do {
            System.out.print("Saisir une nombre : ");
            nombreUser = scanner.nextInt();
            if (nombreUser > nombreMystere) {
                System.out.println("Le nombre est plus petit");
            } else if (nombreUser < nombreMystere) {
                System.out.println("Le nombre est plus grand");
            }
            tentative++;
        } while (nombreUser != nombreMystere);
        System.out.printf("Vous avez trouvé en %d tentative", tentative);
    }
}
