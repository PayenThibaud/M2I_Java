package org.example.Exo6.Classe;

import org.example.Exo6.Interface.Paiement;

public class CarteDeCredit implements Paiement {
    private int numeroDeCarte;
    private String titulaire;
    private String dateExpiration;
    private int codeCVV;

    public CarteDeCredit(int numeroDeCarte, String titulaire, String dateExpiration, int codeCVV) {
        this.numeroDeCarte = numeroDeCarte;
        this.titulaire = titulaire;
        this.dateExpiration = dateExpiration;
        this.codeCVV = codeCVV;
    }

    @Override
    public String effectuerPaiement(double montant) {
        if (montant <= 0) {
            return "Échec sur la carte de credit.";
        }
        else {
            return "Paiement de " + montant + " valider sur la carte de credit.";
        }
    }
}
