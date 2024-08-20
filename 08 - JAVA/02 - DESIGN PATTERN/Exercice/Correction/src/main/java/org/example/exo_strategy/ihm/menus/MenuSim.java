package org.example.strategy.exo.ihm.menus;

import org.example.strategy.exo.ihm.options.*;
import org.example.strategy.exo.simulator.Simulator;

import java.util.List;

public class MenuSim implements Menu{
    Simulator simulator;

    public MenuSim(Simulator simulator) {
        this.simulator = simulator;
    }

    @Override
    public String getName() {
        return "SÉLECTION DE LA STRATÉGIE FISCALE ET SIMULATION";
    }

    @Override
    public String getDescription() {
        return "Choisissez une stratégie fiscale pour la simulation :";
    }

    @Override
    public List<Option> getOptions() {
        return List.of(new OptionImpotProg(simulator), new OptionTva(simulator), new OptionImpotForfaitaire(simulator));
    }

    @Override
    public Option BackOption() {
        return new OptionBack(new MenuPrincipal(simulator));
    }
}
