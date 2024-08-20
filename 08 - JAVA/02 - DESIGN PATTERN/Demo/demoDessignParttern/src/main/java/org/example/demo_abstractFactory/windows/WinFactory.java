package org.example.demo_abstractFactory.windows;

import org.example.demo_abstractFactory.abstracts.Button;
import org.example.demo_abstractFactory.abstracts.CheckBox;
import org.example.demo_abstractFactory.abstracts.GuiFactory;

public class WinFactory extends GuiFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WinCheckBox();
    }
}
