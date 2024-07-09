package org.example.Exercices;

public class Exo02 {
    public static void main(String[] args) {
        int a, b;

        a = 1;
        b = 2;
        System.out.println("Valeur de a au depart  :");
        System.out.println(a);
        System.out.println("Valeur de b au depart : ");
        System.out.println(b);


        a = b;
        b = a;


        System.out.println("Valeur de a la fin  :");
        System.out.println(a);
        System.out.println("Valeur de b a la fin : ");
        System.out.println(b);

        System.out.println("Réponse : non ");
    }
}
