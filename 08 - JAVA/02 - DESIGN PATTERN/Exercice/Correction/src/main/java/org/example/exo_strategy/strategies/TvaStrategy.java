package org.example.strategy.exo.strategies;

import java.util.Scanner;

public class TvaStrategy implements TaxStrategy {
    @Override
    public double calculateTax(double income) {

        while (true) {
            System.out.print("Entrez le Taux de TVA (%): ");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            try {
                double tax = Double.parseDouble(str);
                return income - income * (tax / 100);
            } catch (Exception e) {
                System.out.println("Saisie invalide");
            } finally {
                sc.close();
            }
        }
    }

}
