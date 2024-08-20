package org.example.strategy.exo.ihm.options;

import org.example.strategy.exo.simulator.Simulator;
import org.example.strategy.exo.strategies.ImpotProgressif;

public class OptionImpotProg implements Option{
    Simulator simulator;

    public OptionImpotProg(Simulator simulator) {
        this.simulator = simulator;
    }

    @Override
    public String getName() {
        return "Impôt progressif sur le revenu";
    }

    @Override
    public boolean execute() {
        double res = simulator.simulate(new ImpotProgressif());
        System.out.printf("""
                ========================================================
                   RÉSULTATS DE LA SIMULATION
                ========================================================
                
                Recette : %.2f€
                """, res);
        return true;
    }
}
