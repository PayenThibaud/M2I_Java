package org.example.Exercices;

import java.util.Scanner;

public class Exo05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Valeur de A : ");
        int a = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Valeur de B : ");
        int b = scanner.nextInt();
        scanner.nextLine();

        System.out.println( a + "² + " + b + "² = " + (Math.pow(a, 2) + Math.pow(b, 2)));
    }
}
