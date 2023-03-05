package GUI.screens;

import GUI.util.Util;
import units.Length;
import units.Unit;

import javax.swing.*;

public class ScreenLength extends Screen {

    @Override
    public Unit[] getValues() {
        return Length.getAll();
    }

    @Override
    public String getName() {
        return "Comprimento";
    }

    @Override
    public ImageIcon getImageIcon() {
        return Util.getImageIcon("images/distance.png");
    }
}
