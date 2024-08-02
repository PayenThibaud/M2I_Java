package org.example.Exercice8.Models.CompteBancaire;

import org.example.Exercice8.Models.Client;
import org.example.Exercice8.Models.Operation;
import org.example.Exercice8.Models.StatutOperation;

import java.util.ArrayList;
import java.util.List;

public abstract class CompteBancaire {
    private static int nbCompte = 0;
    protected int id;
    protected double solde;
    protected Client client;
    protected List<Operation> operationList;

    public CompteBancaire( double solde,Client client) {
        this.id = ++nbCompte;
        this.solde = solde;
        this.client = client;
        this.operationList = new ArrayList<>();
        if(solde > 0){
            this.operationList.add(new Operation(solde, StatutOperation.DEPOT));
        }
    }

    public CompteBancaire (Client client){
        this(0,client);
    }

    public int getId() {
        return id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }

    public boolean depot (double montant){
        if(montant<=0){
            return false;
        }
        Operation operation = new Operation(montant,StatutOperation.DEPOT);
        operationList.add(operation);
        solde += montant;
        return true;
    }

    public boolean retrait (double montant){
        if(montant<=0 || solde < montant){
            return false;
        }
        Operation operation = new Operation(montant,StatutOperation.RETRAIT);
        operationList.add(operation);
        solde -= montant;
        return true;
    }

    @Override
    public String toString() {
        return  super.getClass().getSimpleName()+"{" +
                "id=" + id +
                ", solde=" + solde +
                ", operationList=" + operationList +
                '}';
    }
}
