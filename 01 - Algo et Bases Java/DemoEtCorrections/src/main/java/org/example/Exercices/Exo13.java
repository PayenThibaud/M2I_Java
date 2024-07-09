package org.example.Exercices;

import java.util.Scanner;

public class Exo13 {
    public static void main(String[] args) {
        // Declaration des variables
        int ab, bc, ac;

        // Recuperation des valeurs fourni par l'utilisateur
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le longueur de AB : ");
        ab = scanner.nextInt();
        System.out.println("Veuillez saisir le longueur de BC : ");
        bc = scanner.nextInt();
        System.out.println("Veuillez saisir le longueur de AC : ");
        ac = scanner.nextInt();

        // Test sur les longueurs
//        if(ab == bc){
//            // le côté AB est égal à BC
//            if(bc == ac){
//                System.out.println("Le triangle est équilatéral");
//            }else {
//                System.out.println("Le triangle est isocéle en B");
//            }
//        }else {
//            // le côté AB n'est pas égal à BC
//            if(bc == ac){
//                System.out.println("Le triangle est isocéle en C");
//            }else {
//                if(ab == ac){
//                    System.out.println("Le triangle est isocéle en A");
//                }else {
//                    System.out.println("Le triangle n'est pas isocéle");
//                }
//            }
//        }


        // Test sur les longueurs
        if (ab == bc && bc == ac) {
            System.out.println("Le triangle est équilatéral");
        } else if (ab == bc) {
            System.out.println("Le triangle est isocéle en B");
        } else if (bc == ac) {
            System.out.println("Le triangle est isocéle en C");
        } else if (ab == ac) {
            System.out.println("Le triangle est isocéle en A");
        } else {
            System.out.println("Le triangle est quelconque");
        }


        if (ab == bc){
            if(bc == ac) {
                System.out.println("Le triangle est équilatéral");
            } else {
                System.out.println("Le triangle est isocéle en B");
            }
        } else if (bc == ac) {
            System.out.println("Le triangle est isocéle en C");
        } else if (ab == ac) {
            System.out.println("Le triangle est isocéle en A");
        } else {
            System.out.println("Le triangle est quelconque");
        }
    }
}
