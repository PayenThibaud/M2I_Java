package org.example.exo_strategie;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le montant initial:");
        double amount = scanner.nextDouble();
        Income income = new Income(amount);

        System.out.println("Choisissez la stratégie fiscale:");
        System.out.println("1. TVA");
        System.out.println("2. Impot Forfaitaire");
        System.out.println("3. Impot sur le Revenu");
        int choice = scanner.nextInt();

        double result = 0;

        switch (choice) {
            case 1:
                System.out.println("Entrez la TVA");
                double tvaRate = scanner.nextDouble();
                result = income.calculateTax(new TVA(tvaRate));
                break;
            case 2:
                result = income.calculateTax(new ImpotForfaitaire());
                break;
            case 3:
                result = income.calculateTax(new ImpotRevenu());
                break;
            default:
                System.out.println("Choix invalide !");
                return;
        }

        System.out.println("Montant après impot : " + result);
    }
}