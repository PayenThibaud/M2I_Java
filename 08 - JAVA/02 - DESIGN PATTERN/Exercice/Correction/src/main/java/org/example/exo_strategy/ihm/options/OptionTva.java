package org.example.strategy.exo.ihm.options;

import org.example.strategy.exo.simulator.Simulator;
import org.example.strategy.exo.strategies.TvaStrategy;

public class OptionTva implements Option{
    Simulator sim;
    public OptionTva(Simulator simulator) {
        sim = simulator;
    }

    @Override
    public String getName() {
        return "TVA (Taxe sur la valeur ajoutée)";
    }

    @Override
    public boolean execute() {
        double res = sim.simulate(new TvaStrategy());
        System.out.printf("""
                ========================================================
                   RÉSULTATS DE LA SIMULATION
                ========================================================
                
                Recette : %.2f€
                """, res);
        return true;
    }
}
