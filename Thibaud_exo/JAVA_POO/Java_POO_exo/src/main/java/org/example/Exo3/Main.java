package org.example.Exo3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<WaterTank> citernes = new ArrayList<>();
    private static int numeroCiterne = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Créer une nouvelle citerne");
            System.out.println("2. Remplir une citerne");
            System.out.println("3. Vider une citerne");
            System.out.println("4. Afficher le poids total d'une citerne");
            System.out.println("5. Afficher le poids total en eau de toutes les citernes");
            System.out.println("6. Quitter");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    numeroCiterne++;
                    System.out.println("Entrez le poids vide de la citerne : ");
                    int poidsVide = scanner.nextInt();
                    System.out.println("Entrez la capacité totale de la citerne : ");
                    int capaciteTotal = scanner.nextInt();
                    System.out.println("Entrez le niveau de remplissage initial de la citerne : ");
                    int niveauRemplissage = scanner.nextInt();
                    WaterTank nouvelleCiterne = new WaterTank(poidsVide, capaciteTotal, niveauRemplissage);
                    citernes.add(nouvelleCiterne);
                    System.out.println("Nouvelle citerne créée avec l'index : " + (numeroCiterne - 1));
                    break;
                case 2:
                    System.out.println("Entrez l'index de la citerne à remplir : ");
                    int indexRemplir = scanner.nextInt();
                    if (indexRemplir < 0 || indexRemplir >= citernes.size()) {
                        System.out.println("Aucune citerne trouvée à cet index. Créez d'abord une citerne.");
                    } else {
                        System.out.println("Entrez le nombre de litres à ajouter : ");
                        int litresAjoutes = scanner.nextInt();
                        citernes.get(indexRemplir).remplirCiterne(litresAjoutes);
                    }
                    break;
                case 3:
                    System.out.println("Entrez l'index de la citerne à vider : ");
                    int indexVider = scanner.nextInt();
                    if (indexVider < 0 || indexVider >= citernes.size()) {
                        System.out.println("Aucune citerne trouvée à cet index. Créez d'abord une citerne.");
                    } else {
                        System.out.println("Entrez le nombre de litres à retirer : ");
                        int litresRetires = scanner.nextInt();
                        citernes.get(indexVider).viderCiterne(litresRetires);
                    }
                    break;
                case 4:
                    System.out.println("Entrez l'index de la citerne : ");
                    int indexAfficher = scanner.nextInt();
                    if (indexAfficher < 0 || indexAfficher >= citernes.size()) {
                        System.out.println("Aucune citerne trouvée à cet index. Créez d'abord une citerne.");
                    } else {
                        citernes.get(indexAfficher).getPoidsTotal();
                    }
                    break;
                case 5:
                    WaterTank.getPoidsEauTotal();
                    break;
                case 6:
                    System.out.println("bye bye =D");
                    scanner.close();
                    return;
                default:
                    System.out.println("erreur");
            }
        }
    }
}

