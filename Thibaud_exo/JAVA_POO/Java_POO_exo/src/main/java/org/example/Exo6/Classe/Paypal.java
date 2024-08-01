package org.example.Exo6.Classe;

import org.example.Exo6.Interface.Paiement;

public class Paypal implements Paiement {

    private String email;
    private String mdp;

    public Paypal(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    @Override
    public String effectuerPaiement(double montant) {
        if (montant <= 0) {
            return "Échec sur Paypal";
        }
        else {
            return "Paiement de " + montant + " valider sur Paypal.";
        }
    }
}
