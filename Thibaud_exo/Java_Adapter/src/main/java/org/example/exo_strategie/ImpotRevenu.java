package org.example.exo_strategie;

public class ImpotRevenu implements TaxStrategy
{
    @Override
    public double calculateTax(Income income) {
        double tax = 0;
        double incomeAmount = income.getAmount();

        if (incomeAmount > 100000) {
            tax += (incomeAmount - 100000) * 0.35;
            incomeAmount = 100000;
        }

        if (incomeAmount > 10000) {
            tax += (incomeAmount - 10000) * 0.15;
            incomeAmount = 10000;
        }

        if (incomeAmount > 0) {
            tax += incomeAmount * 0.05;
        }

        double amountAfterTax = income.getAmount() - tax;

        return amountAfterTax;
    }
}