package org.example.Exercice6.models;

import org.example.Exercice6.interfaces.Paiment;

public class Paypal implements Paiment {

    private String email;
    private String mdp;

    public Paypal(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    @Override
    public String effectuerPayement(double montant) {
        if(montant>0){
            return "Payement effectué Paypal de credit d'un montant de : "+ montant+" €";
        }else{
            return "payement impossible montant incorrecte";
        }
    }
}
