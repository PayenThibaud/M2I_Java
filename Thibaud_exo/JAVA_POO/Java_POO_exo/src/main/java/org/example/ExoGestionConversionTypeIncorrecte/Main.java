package org.example.ExoGestionConversionTypeIncorrecte;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.example.ExoGestionConversionTypeIncorrecte.Exception.ChainePasUnEntier;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean boucle = true;

        while (boucle) {
            System.out.print("Entrer une chaîne de caractère : ");
            String chaine = scanner.nextLine();

            try {
                int entier = convertirChaineEnEntier(chaine);
                System.out.println("Le String est mtn un int : " + entier);
                boucle = false;
            } catch (ChainePasUnEntier e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int convertirChaineEnEntier(String chaine) {
        try {
            return Integer.parseInt(chaine);
        } catch (NumberFormatException e) {
            throw new ChainePasUnEntier("La chaine n'est pas un entier : " + chaine);
        }
    }
}
