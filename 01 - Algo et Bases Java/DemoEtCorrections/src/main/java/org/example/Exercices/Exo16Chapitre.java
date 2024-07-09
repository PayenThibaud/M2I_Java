package org.example.Exercices;

public class Exo16Chapitre {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            System.out.printf("Chapitre %d\n", i);
            for (int j = 1; j <= 3; j++) {
                System.out.printf("\tSous-chapitre %d.%d%n", i, j);
            }
        }
    }
}
