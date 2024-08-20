package org.example.exo_strategie;

public class Income {

    private double amount;

    public Income(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double calculateTax(TaxStrategy taxStrategy) {return taxStrategy.calculateTax(this);}
}
