package org.example.Exercice8.Models.CompteBancaire;

import org.example.Exercice8.Models.Client;

public class CompteEpargne extends CompteBancaire{

    private double taux;

    public CompteEpargne(double solde, Client client,double taux) {
        super(solde, client);
        this.taux= taux;
    }

    public CompteEpargne(Client client,double taux) {
        super(client);
        this.taux= taux;
    }

    public double calculeInterets(int anneesPlacment){
        double interrets = 0;
        double soldeCalcul = this.solde;
        for (int i = 0; i < anneesPlacment;i++){
            interrets = soldeCalcul * (taux/100);
            soldeCalcul+= interrets;
        }
        return interrets;
    }
}
