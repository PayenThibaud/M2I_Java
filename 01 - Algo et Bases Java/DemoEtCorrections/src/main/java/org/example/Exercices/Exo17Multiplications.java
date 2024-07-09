package org.example.Exercices;

public class Exo17Multiplications {
    public static void main(String[] args) {
//        // version en lignes
//        for (int i = 1; i <= 10; i++) {
//            System.out.printf("Table des %d :\n", i);
//            for (int j = 1; j <= 10; j++) {
//                System.out.printf("\t%d x %d = %d\n", i, j, i*j);
//            }
//            System.out.println();
//        }

//        // version en tableau avec tabulations
//        for (int i = 1; i <= 1000; i++) {
//            for (int j = 1; j <= 10; j++) {
//                System.out.printf("\t%d", i*j);
//            }
//            System.out.println();
//        }


//        // version en tableau avec printf et espaces alloués
//        for (int i = 1; i <= 1000; i++) {
//            for (int j = 1; j <= 10; j++) {
//                System.out.printf("%5d", i*j);
//            }
//            System.out.println();
//        }


        System.out.println("\n        Tables de multiplications:");
        for (int i = 0; i < 3; i++) {
            if (i == 0 || i == 2) {
                for (int j = 0; j < 41; j++) {
                    System.out.print("=");
                }
                System.out.println();
            } else {
                for (int j = 1; j <= 10; j++) {
                    System.out.printf("|%2s ", j);
                }
                System.out.println("|");
            }
        }

        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("|%2s", i * j);
                if (i * j < 100) {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
            for (int j = 0; j < 10; j++) {
                System.out.print("+---");
            }
            System.out.println("+");
        }
    }
}
