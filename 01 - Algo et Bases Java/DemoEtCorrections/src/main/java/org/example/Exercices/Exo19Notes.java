package org.example.Exercices;

import java.util.Scanner;

public class Exo19Notes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisir note 1 : ");
        double note1 = scanner.nextDouble();

        double min = note1;
        double max = note1;
        double sum = note1;


        // n notes
//        int nbNotesMax = 20;
//        for (int i = 2; i <= nbNotesMax; i++) {
//            System.out.printf("Saisir note %d : ", i);
//            double note = scanner.nextDouble();
//            scanner.nextLine();
//            sum += note;
//            if (note < min) min = note;
//            else if (note > max) max = note;
//        }
        // notes jusqu'à saisie de "0"
        int nbNotesMax = 1;
        while (true) {
            nbNotesMax ++;
            System.out.printf("Saisir note %d : ", nbNotesMax);
            double note = scanner.nextDouble();
            scanner.nextLine();
            if(0<note && note<=20) {
                sum += note;
                if (note < min) min = note;
                else if (note > max) max = note;
            } else {
                nbNotesMax--;
                break;
            }
        }

        double moy = sum/nbNotesMax;

        String choice;
        do {
            System.out.println("Choose an option: 1 for lowest grade, 2 for highest grade, 3 for average, 0 to exit");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> System.out.println("The lowest grade is: " + min);
                case "2" -> System.out.println("The highest grade is: " + max);
                case "3" -> System.out.println("The average is: " + moy);
                case "0" -> System.out.println("Goodbye");
                default -> System.out.println("Invalid choice");
            }
        } while (!choice.equals("0"));
    }
}
