package org.example.Exercice6.models;

import org.example.Exercice6.interfaces.Paiment;

import java.time.LocalDate;
import java.util.Date;

public class CarteDeCredit implements Paiment {
    private String numeroCarte;
    private String titulaire;
    private LocalDate dateExpiration;
    private String cvv;

    public CarteDeCredit(String numeroCarte, String titulaire, LocalDate dateExpiration, String cvv) {
        this.numeroCarte = numeroCarte;
        this.titulaire = titulaire;
        this.dateExpiration = dateExpiration;
        this.cvv = cvv;
    }

    @Override
    public String effectuerPayement(double montant) {
        if(montant>0){
            return "Payement effectué via la carte de credit d'un montant de : "+ montant+" €";
        }else{
            return "payement impossible montant incorrecte";
        }
    }
}
