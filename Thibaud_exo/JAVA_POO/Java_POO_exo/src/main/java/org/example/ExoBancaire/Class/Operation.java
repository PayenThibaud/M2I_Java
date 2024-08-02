package org.example.ExoBancaire.Class;

import org.example.ExoBancaire.Enum.TypeOperation;

public class Operation {
    private TypeOperation operation;
    private double montant;
    private int numero;

    public Operation(TypeOperation operation, double montant, int numero) {
        this.operation = operation;
        this.montant = montant;
        this.numero = numero;
    }

    public TypeOperation getOperation() {
        return operation;
    }
    public void setOperation(TypeOperation operation) {
        this.operation = operation;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "\n \t" + numero + ": Operation de " + operation + " d'un montant de " + montant ;
    }

}
