package GUI.screens;

import GUI.util.Util;
import units.Money;
import units.Unit;

import javax.swing.*;

public class ScreenMoney extends Screen {

    @Override
    public Unit[] getValues() {
        return Money.getAll();
    }

    @Override
    public String getName() {
        return "Moedas";
    }

    @Override
    public ImageIcon getImageIcon() {
        return Util.getImageIcon("images/money.png");
    }
}
