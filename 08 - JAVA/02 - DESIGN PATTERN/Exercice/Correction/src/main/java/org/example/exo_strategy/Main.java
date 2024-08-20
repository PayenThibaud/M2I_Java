package org.example.strategy.exo;

import org.example.strategy.exo.ihm.menus.MenuPrincipal;
import org.example.strategy.exo.ihm.menus.MenuUtils;
import org.example.strategy.exo.simulator.Simulator;

public class Main {
    public static void main(String[] args) {
        Simulator simulator = new Simulator(1500);
        MenuPrincipal menu = new MenuPrincipal(simulator);
        MenuUtils.printMenu(menu);
    }
}
