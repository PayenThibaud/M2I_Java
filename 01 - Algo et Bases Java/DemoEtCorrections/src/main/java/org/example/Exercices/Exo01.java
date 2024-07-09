package org.example.Exercices;

public class Exo01 {
    public static void main(String[] args) {
//        int a;
//        int b;
//        int c;

        int a, b, c; // Variables A, B, C : Entier

        a = 3;
        b = 7;
        a = b; // (devient 7)
        b = a + 5; // (devient 7+5=12)
        c = a + b; // (devient 7+12=19)
        c = b - a; // (devient 12-7=5)

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
