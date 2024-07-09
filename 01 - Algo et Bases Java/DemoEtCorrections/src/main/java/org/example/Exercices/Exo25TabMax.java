package org.example.Exercices;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Exo25TabMax {
    public static void main(String[] args) {
        int[] tableau = {1, 5, 7, 2, 9, 3};
//        int[] tableau = {
//                new Random().nextInt(), // à éviter : réinstancier random plusieurs fois + répétition de code (for)
//                new Random().nextInt(),
//                new Random().nextInt(),
//                new Random().nextInt(),
//                new Random().nextInt(),
//                new Random().nextInt()
//        };

        int max = tableau[0];
        int index = 0;

        for (int i = 1; i < tableau.length; i++) {
            if (tableau[i] > max) {
                max = tableau[i];
                index = i;
            }
        }

        System.out.println("La valeur maximale est : " + max + ", à l'index :" + index);

//         version avancée : (à voir dans la partie POO avec les Streams)
//        int max = Arrays.stream(tableau).max().getAsInt();
//        int index = IntStream.range(0, tableau.length).filter(i -> tableau[i] == max).toArray()[0]; // Importer en haut: import java.util.stream.IntStream;
//        System.out.println("La valeur maximale est : " + max + ", à l'index :" + index);
    }
}
