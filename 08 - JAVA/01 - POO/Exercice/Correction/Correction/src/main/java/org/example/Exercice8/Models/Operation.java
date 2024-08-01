package org.example.Exercice8.Models;

public class Operation {

    private static  int nbOperation = 0;
    private final int id;
    private double montant;
    private StatutOperation statut;

    public Operation(double montant, StatutOperation statut) {
        this.id = ++nbOperation;
        this.montant = montant;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public StatutOperation getStatut() {
        return statut;
    }

    public void setStatut(StatutOperation statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", montant=" + montant +
                ", statut=" + statut +
                '}';
    }
}
