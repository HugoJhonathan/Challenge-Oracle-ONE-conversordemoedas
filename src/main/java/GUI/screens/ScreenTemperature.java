package GUI.screens;

import GUI.util.Util;
import units.Temperature;
import units.Unit;

import javax.swing.*;

public class ScreenTemperature extends Screen {

    @Override
    public Unit[] getValues() {
        return Temperature.getAll();
    }

    @Override
    public String getName() {
        return "Temperatura";
    }

    @Override
    public ImageIcon getImageIcon() {
        return Util.getImageIcon("images/temperature.png");
    }
}
