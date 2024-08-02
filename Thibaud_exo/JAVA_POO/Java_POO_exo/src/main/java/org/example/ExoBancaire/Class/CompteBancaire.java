package org.example.ExoBancaire.Class;

import org.example.ExoBancaire.Enum.TypeOperation;

import java.util.List;

public abstract class CompteBancaire {
    protected double solde;
    protected Client client;
    protected List<Operation> operations;

    public CompteBancaire(double solde, Client client, List<Operation> operations) {
        this.solde = solde;
        this.client = client;
        this.operations = operations;
    }

    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public List<Operation> getOperations() {
        return operations;
    }
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public void ajouterOperation(TypeOperation operation, double montant) {
        if (operation == TypeOperation.DEPOT) {
            solde += montant;
        } else if (operation == TypeOperation.RETRAIT) {
            solde -= montant;
        }
        operations.add(new Operation(operation, montant, operations.size() + 1));
    }

    public String toString() {
        return "Compte Courant de " + client + ", solde: " + solde + ", operations: " + operations;
    }




}
