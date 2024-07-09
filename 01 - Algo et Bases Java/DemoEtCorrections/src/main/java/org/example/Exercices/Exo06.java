package org.example.Exercices;

import java.util.Scanner;

public class Exo06 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Saisir un age :");
//        int age = scanner.nextInt();
//        boolean majeur = age >= 18;
//        System.out.println(majeur);
//
//        Scanner scanner2 = new Scanner(System.in);
//        System.out.println("Saisir un age :");
//        System.out.println(scanner2.nextInt() >= 18);

//
//        System.out.println("Saisir un age :");
//        System.out.println(new Scanner(System.in).nextInt() >= 18);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir un age :");
        int age = scanner.nextInt();
        String chaine = age >= 18 ? "Majeur" : "Mineur" ;
        System.out.println(chaine);
    }
}
