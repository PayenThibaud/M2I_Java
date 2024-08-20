package org.example.strategy.exo.ihm.options;

public class OptionQuit implements Option{
    @Override
    public String getName() {
        return "Quitter";
    }

    @Override
    public boolean execute() {
        System.exit(0);
        return true;
    }
}
