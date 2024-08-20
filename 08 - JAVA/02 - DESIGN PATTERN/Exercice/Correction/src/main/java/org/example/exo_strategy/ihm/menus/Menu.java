package org.example.strategy.exo.ihm.menus;

import org.example.strategy.exo.ihm.options.Option;

import java.util.List;

public interface Menu {

    String getName();

    String getDescription();

    List<Option> getOptions();

    Option BackOption();
}
