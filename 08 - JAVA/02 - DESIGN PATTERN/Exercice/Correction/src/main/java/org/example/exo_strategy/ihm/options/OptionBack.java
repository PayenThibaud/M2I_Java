package org.example.strategy.exo.ihm.options;

import org.example.strategy.exo.ihm.menus.Menu;
import org.example.strategy.exo.ihm.menus.MenuUtils;

public class OptionBack implements Option {
    Menu menu;
    public OptionBack(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String getName() {
        return "Retour";
    }

    @Override
    public boolean execute() {
        if(menu == null) return false;

        MenuUtils.printMenu(menu);
        return true;
    }
}
