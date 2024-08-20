package org.example.strategy.exo.ihm.options;

import org.example.strategy.exo.ihm.menus.MenuSim;
import org.example.strategy.exo.ihm.menus.MenuUtils;
import org.example.strategy.exo.simulator.Simulator;

public class OptionSelectStrat implements Option{
    Simulator simulator;

    public OptionSelectStrat(Simulator simulator) {
        this.simulator = simulator;
    }

    @Override
    public String getName() {
        return "Sélectionner la stratégie fiscale et lancer la simulation";
    }

    @Override
    public boolean execute() {
        MenuUtils.printMenu(new MenuSim(simulator));
        return true;
    }
}
