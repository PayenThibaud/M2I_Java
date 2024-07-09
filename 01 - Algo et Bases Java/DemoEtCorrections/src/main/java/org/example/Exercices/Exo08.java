package org.example.Exercices;

import java.util.Arrays;
import java.util.Scanner;

public class Exo08 {
    public static void main(String[] args) {
//        Saisir une chaîne : CoMMenT çA vA ?
        Scanner scanner = new Scanner(System.in);
        System.out.print("Saisir une chaîne :");
        String chaine = scanner.nextLine();
//        En minuscule : comment ça va ?
        System.out.println("En minuscule : " + chaine.toLowerCase());
//        En majuscule : COMMENT ÇA VA ?
        System.out.println("En majuscule : " + chaine.toUpperCase());
//        En tableau : c,o,m,m,e,n,t, ,ç,a, ,v,a, ,?
        System.out.println("En tableau : " + String.join(",", chaine.split("")));
        System.out.println("En tableau : " + Arrays.toString(chaine.toCharArray()));

    }
}
