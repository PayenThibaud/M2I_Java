package org.example.demo_abstractFactory.mac;

import org.example.demo_abstractFactory.abstracts.Button;
import org.example.demo_abstractFactory.abstracts.CheckBox;
import org.example.demo_abstractFactory.abstracts.GuiFactory;

public class MacFactory extends GuiFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckbox();
    }
}
