package org.example.exo_strategie;

public class ImpotForfaitaire implements TaxStrategy{
    @Override
    public double calculateTax(Income income) {
        double tax = 500;
        double incomeAmount = income.getAmount();

        return incomeAmount - tax;
    }
}
