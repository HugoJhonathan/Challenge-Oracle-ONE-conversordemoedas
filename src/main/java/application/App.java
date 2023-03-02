package application;

import GUI.Window;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        SwingUtilities.invokeLater(Window::new);
    }
}