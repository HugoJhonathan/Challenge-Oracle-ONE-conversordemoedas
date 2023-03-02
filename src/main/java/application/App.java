package application;

import GUI.Window;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Window::new);
    }
}