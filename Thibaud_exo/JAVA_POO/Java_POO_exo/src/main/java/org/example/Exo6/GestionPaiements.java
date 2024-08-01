package org.example.Exo6;

import org.example.Exo6.Classe.CarteDeCredit;
import org.example.Exo6.Classe.Paypal;
import org.example.Exo6.Interface.Paiement;

public class GestionPaiements {
    public static void main(String[] args) {
        Paiement carte = new CarteDeCredit(1,"Titi", "01.01.01", 1);

        System.out.println(carte.effectuerPaiement(100));
        System.out.println(carte.effectuerPaiement(-10));

        Paiement paypal = new Paypal("Titi", "01.01.01");

        System.out.println(paypal.effectuerPaiement(100));
        System.out.println(paypal.effectuerPaiement(-10));


        Paiement[] paiements = new Paiement[]{
                new CarteDeCredit(2,"Titi", "01.01.01", 1),
                new Paypal("Titi", "01.01.01"),
        };

        for (Paiement paiement : paiements) {
            System.out.println(paiement.effectuerPaiement(100));
            System.out.println(paiement.effectuerPaiement(-10));
        }


    }
}
