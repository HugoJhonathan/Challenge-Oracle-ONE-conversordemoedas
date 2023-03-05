package GUI.screens;

import GUI.util.Util;
import units.DataStorage;
import units.Unit;

import javax.swing.*;

public class ScreenDataStorage extends Screen {

    @Override
    public Unit[] getValues() {
        return DataStorage.getAll();
    }

    @Override
    public String getName() {
        return "Armazenamento";
    }

    @Override
    public ImageIcon getImageIcon() {
        return Util.getImageIcon("images/datastorage.png");
    }

}
