package org.example.strategy.exo.ihm.options;

import org.example.strategy.exo.simulator.Simulator;
import org.example.strategy.exo.strategies.ImpotForfaitaire;

public class OptionImpotForfaitaire implements Option{
    Simulator simulator;

    public OptionImpotForfaitaire(Simulator simulator) {
        this.simulator = simulator;
    }

    @Override
    public String getName() {
        return "Impôt forfaitaire";
    }

    @Override
    public boolean execute() {
        double res = simulator.simulate(new ImpotForfaitaire());
        System.out.printf("""
                ========================================================
                   RÉSULTATS DE LA SIMULATION
                ========================================================
                
                Recette : %.2f€
                """, res);
        return true;
    }
}
