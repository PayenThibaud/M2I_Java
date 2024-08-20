package org.example.strategy.exo.ihm.menus;

import org.example.strategy.exo.ihm.options.Option;
import org.example.strategy.exo.ihm.options.OptionQuit;
import org.example.strategy.exo.ihm.options.OptionSelectStrat;
import org.example.strategy.exo.simulator.Simulator;

import java.util.List;

public class MenuPrincipal implements Menu {
    Simulator simulator;

    public MenuPrincipal(Simulator simulator) {
        this.simulator = simulator;
    }

    @Override
    public String getName() {
        return "SImULATEUR DE POLITIQUE FISCALE - MENU PRINCIPAL";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public List<Option> getOptions() {
        return List.of(new OptionSelectStrat(simulator));
    }



    @Override
    public Option BackOption() {
        return new OptionQuit();
    }
}
