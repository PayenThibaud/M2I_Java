package org.example.ExoRacineCarre;

import org.example.ExoRacineCarre.Exception.NombreNonPositif;
import org.example.ExoRacineCarre.Exception.NonNumerique;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean boucle = true;

        while (boucle) {
            System.out.print("Entrer un nombre : ");
            String chaine = scanner.nextLine();

            try {
                double nombre = convertirChaineEnDouble(chaine);

                if (nombre < 0) {
                    throw new NombreNonPositif("Le nombre ne peut pas être négatif : " + nombre);
                }

                double racineCarree = Math.sqrt(nombre);
                System.out.println("La racine carree de " + nombre + " est : " + racineCarree);
                boucle = false;
            } catch (NonNumerique e) {
                System.out.println(e.getMessage());
            } catch (NombreNonPositif e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static double convertirChaineEnDouble(String chaine) {
        try {
            return Double.parseDouble(chaine);
        } catch (NumberFormatException e) {
            throw new NonNumerique("Ce n'est pas un nombre : " + chaine);
        }
    }
}
