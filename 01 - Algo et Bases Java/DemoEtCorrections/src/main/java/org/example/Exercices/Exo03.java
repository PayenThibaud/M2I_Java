package org.example.Exercices;

import java.util.Scanner;

public class Exo03 {
    public static void main(String[] args) {
        int a,b;
        Scanner scanner = new Scanner(System.in);
//        a = 51;
//        b = 26;

        System.out.print("Saisir la valeur de a au depart  :");
        a = scanner.nextInt();
        System.out.print("Saisir la valeur de b au depart : ");
        b = scanner.nextInt();

        scanner.nextLine();

        int temp = a;
        a = b;
        b = temp;

        System.out.println("Valeur de a la fin  :");
        System.out.println(a);
        System.out.println("Valeur de b a la fin : ");
        System.out.println(b);
    }
}
