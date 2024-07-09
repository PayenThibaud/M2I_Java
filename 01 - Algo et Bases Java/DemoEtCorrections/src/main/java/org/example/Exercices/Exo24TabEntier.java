package org.example.Exercices;

import java.util.Arrays;

public class Exo24TabEntier {
    public static void main(String[] args) {
        int[] tab = {16, -2, 3, 4, -5, -16, 2, -3, 54, 5};
        int[] sortedTab = new int[tab.length];

        int indexSortedTab = 0;
        for (int number : tab) {
            if (number > 0) {
                sortedTab[indexSortedTab] = number;
                indexSortedTab++;
            }
        }
        System.out.println(Arrays.toString(sortedTab));

//        int indexSortedTab = 0;
//        for (int i = 0; i < tab.length; i++) { // number => tab[i]
//            if (tab[i] > 0) {
//                sortedTab[indexSortedTab] = tab[i];
//                indexSortedTab++;
//            }
//        }
//        System.out.println(Arrays.toString(sortedTab));
    }
}
