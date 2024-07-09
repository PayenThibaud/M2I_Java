package org.example.Exercices;

import java.util.Scanner;

public class Exo30CompteA {

    public static int compterLettresA(String chaine) {
        int compte = 0;
        for (char lettre : chaine.toCharArray()) {
//            if (lettre == 'a' || lettre == 'A') {
            if (Character.toLowerCase(lettre) == 'a') {
                compte++;
            }
        }
        return compte;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir phrase : ");
        String saisie = scanner.nextLine();
        scanner.close();

        System.out.println(compterLettresA(saisie));

        char t = 'a';
        char t1 = '\0';
//        char t2 = null;

        Character t3 = 'a';
        Character t4 = null;
        Character t5 = '\0';

    }
}
