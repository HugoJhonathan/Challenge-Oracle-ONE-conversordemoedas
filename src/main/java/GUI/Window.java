package GUI;

import GUI.screens.*;
import GUI.util.Util;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Window extends JFrame {

    private NavBar navBar;
    private JPanel pageContentContainer;

    public Window() {
        init();
        setVisible(true);
    }

    public NavBar getNavBar() {
        if (Objects.nonNull(navBar)) return navBar;
        navBar = new NavBar(getPageContentContainer());
        navBar.createItem(new ScreenMoney());
        navBar.createItem(new ScreenLength());
        navBar.createItem(new ScreenDataStorage());
        navBar.createItem(new ScreenMass());
        navBar.createItem(new ScreenTemperature());
        return navBar;
    }

    public JPanel getPageContentContainer() {
        if (Objects.nonNull(pageContentContainer)) return pageContentContainer;
        pageContentContainer = new JPanel(new CardLayout());
        return pageContentContainer;
    }

    public void init() {
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
            UIManager.put("JFrame.activeTitleBackground", Color.red);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        setIconImage(Util.getImage("images/icon.png"));
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setResizable(true);
        setSize(600, 600);
        setLocationRelativeTo(null);
        add(getNavBar(), BorderLayout.WEST);
        add(getPageContentContainer(), BorderLayout.CENTER);
        getNavBar().markFirstNavItem();
    }


}
