package org.example.ExoBancaire.Class;

import org.example.ExoBancaire.Enum.TypeOperation;

import java.util.List;

public class ComptePayant extends CompteBancaire {
    public ComptePayant(double solde, Client client, List<Operation> operations) {
        super(solde, client, operations);
    }

    @Override
    public String toString() {
        return "Compte Payant de " + client + ", solde: " + solde + ", operations: " + operations;
    }

    @Override
    public void ajouterOperation(TypeOperation operation, double montant) {
        if (operation == TypeOperation.DEPOT) {
            solde += montant - (montant*0.01);
        } else if (operation == TypeOperation.RETRAIT) {
            solde -= montant + (montant*0.01);
        }
        operations.add(new Operation(operation, montant, operations.size() + 1));
    }
}
