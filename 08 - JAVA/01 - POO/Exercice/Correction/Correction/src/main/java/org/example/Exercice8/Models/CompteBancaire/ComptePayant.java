package org.example.Exercice8.Models.CompteBancaire;

import org.example.Exercice8.Models.Client;

import java.util.Date;

public class ComptePayant extends CompteBancaire {

    private  double coutOperation = 0.2;
    public ComptePayant(double solde, Client client) {
        super(solde, client);
    }

    public ComptePayant(Client client) {
        super(client);
    }

    @Override
    public boolean depot(double montant) {
        if(solde+montant < coutOperation){
            return false;
        }
        super.depot(montant);
        super.retrait(coutOperation);
        return true;
    }

    @Override
    public boolean retrait(double montant) {
        if(solde <= coutOperation+montant ){
            return false;
        }
        super.retrait(montant);
        super.retrait(coutOperation);
        return true;
    }
}
