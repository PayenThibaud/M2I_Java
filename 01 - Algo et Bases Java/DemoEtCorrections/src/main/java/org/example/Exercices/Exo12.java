package org.example.Exercices;

import java.util.Scanner;

public class Exo12 {
    public static void main(String[] args) {
        int age;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir l'age de l'enfant :");
        age = scanner.nextInt();
        System.out.println("Votre enfant à " + age + " ans.");

        if (age < 3 || age >= 18) {
            System.out.println("Vous ne pouvez pas vous inscrire au club");
        } else {
            System.out.println("Voyons dans quelle catégorie : ");
            if (age <= 6) {
                System.out.println("- Baby");
            } else {
                if (age <= 8) {
                    System.out.println("- Poussin");
                } else {
                    if (age <= 10) {
                        System.out.println("- Pupille");
                    } else {
                        if (age <= 12) {
                            System.out.println("- Minime");
                        } else {
                            System.out.println("- Cadet");
                        }
                    }
                }
            }
        }

        if (age < 3 || age >= 18) {
            System.out.println("Vous ne pouvez pas vous inscrire au club");
        } else {
            System.out.print("Voyons dans quelle catégorie : ");
            if (age <= 6) {
                System.out.println("- Baby");
            } else if (age <= 8) {
                System.out.println("- Poussin");
            } else if (age <= 10) {
                System.out.println("- Pupille");
            } else if (age <= 12) {
                System.out.println("- Minime");
            } else {
                System.out.println("- Cadet");
            }
        }


        switch (age){
            case 3,4,5,6:
                System.out.println("- Baby");
                break;
            case 7,8:
                System.out.println("- Poussin");
                break;
            case 9,10:
                System.out.println("- Pupille");
                break;
            case 11,12:
                System.out.println("- Minime");
                break;
            case 13,14,15,16,17:
                System.out.println("- Cadet");
                break;
            default:
                System.out.println("Vous ne pouvez pas vous inscrire au club");
                break;
        }

        switch (age) {
            case 3, 4, 5, 6 -> System.out.println("- Baby");
            case 7, 8 -> System.out.println("- Poussin");
            case 9, 10 -> System.out.println("- Pupille");
            case 11, 12 -> System.out.println("- Minime");
            case 13, 14, 15, 16, 17 -> System.out.println("- Cadet");
            default -> System.out.println("Vous ne pouvez pas vous inscrire au club");
        }
    }
}
