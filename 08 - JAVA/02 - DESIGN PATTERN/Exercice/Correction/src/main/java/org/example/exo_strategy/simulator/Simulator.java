package org.example.strategy.exo.simulator;

import org.example.strategy.exo.strategies.TaxStrategy;

public class Simulator {
    private double amount;

    public Simulator(double amount) {
        this.amount = amount;
    }

    public Simulator() {
        this.amount = 0;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double simulate(TaxStrategy taxStrategy) {
        return taxStrategy.calculateTax(amount);
    }
}
