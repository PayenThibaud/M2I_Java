package org.example.exo_strategie;

public class TVA implements TaxStrategy {

    private double tva;

    public TVA(double tva) {
        this.tva = tva;
    }

    @Override
    public double calculateTax(Income income) {

        double incomeAmount = income.getAmount();

        return incomeAmount - (incomeAmount * (tva / 100.0));
    }
}
