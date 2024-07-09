package org.example.Exercices;

public class Exo28Soustraction {
    public static int soustraire(int a, int b){
        System.out.printf("Je soustrait %d et %d\n", a, b);
        return a - b;
    }

    public static void main(String[] args) {
        System.out.println("Résultat : " + soustraire(2, 1));
    }
}
