package GUI.util;

import units.Unit;

import javax.swing.*;
import java.awt.*;

public class DistanceRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Unit valUnit = (Unit) value;
        setText(valUnit.getSymbol() + " - " + valUnit.getName());
        return this;
    }
}