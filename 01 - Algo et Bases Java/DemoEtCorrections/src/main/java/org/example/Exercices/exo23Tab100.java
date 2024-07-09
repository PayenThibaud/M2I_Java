package org.example.Exercices;

public class exo23Tab100 {
    public static void main(String[] args) {
        int[] tab100 = new int[100];
        for (int i = 0; i < 100; i++) {
            tab100[i] = i;
        }

//        for (int i = 0; i < tab100.length; i++) {
////            System.out.println(tab100[i]);
//            if (i % 10 == 0){
////                System.out.print("\n"+tab100[i]+",");
//                System.out.printf("\n%3d,", tab100[i]);
//            } else {
////                System.out.print("\t"+tab100[i]+",");
//                System.out.printf("%3d,", tab100[i]);
//            }
//        }
//
//        for (int i = 0; i < tab100.length; i++) {
////            System.out.println(tab100[i]);
//            if (i % 10 == 0){
//                System.out.print("\n"+tab100[i]+",");
//            } else {
//                System.out.print("\t"+tab100[i]+",");
//            }
//        }

        for (int i = 0; i < tab100.length; i++) {
            if ((i % 10)-9 == 0){
                System.out.printf("%3d\n", tab100[i]);
            } else {
                System.out.printf("%3d,", tab100[i]);
            }
        }


        StringBuilder affichage = new StringBuilder();
        for (int i = 0; i < tab100.length; i++) {
            if ((i % 10)-9 == 0){
                affichage.append(String.format("%3d\n", tab100[i]));
            } else {
                affichage.append(String.format("%3d,", tab100[i]));
            }
        }
        System.out.print(affichage);
    }
}
