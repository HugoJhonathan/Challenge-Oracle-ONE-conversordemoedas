package GUI;

import GUI.screens.Screen;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorChooserUI;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NavBar extends JPanel {

    private JLabel title;
    private JPanel navItems;
    private JPanel footer;
    private final JPanel pageContentContainer;
    private final CardLayout cardLayout;
    private final Map<Component, JButton> navItemAndPainel = new HashMap<>();
    private final Color navBarColor = new Color(17, 17, 17);
    private final Color navBarSelected = new Color(0, 0, 0);
    private final String hiperlink = "Developed by hugo_";

    public NavBar(JPanel component) {
        pageContentContainer = component;
        cardLayout = (CardLayout) component.getLayout();
        init();
    }

    public void init() {
        setLayout(new BorderLayout(0, 0));
        setBackground(navBarColor);
        setPreferredSize(new Dimension(180, 0));
        add(getTitle(), BorderLayout.PAGE_START);
        add(getNavItems(), BorderLayout.CENTER);
        add(getFooter(), BorderLayout.PAGE_END);
    }

    public JLabel getTitle() {
        if (Objects.nonNull(title)) return title;
        title = new JLabel("CONVERSORES");
        title.setBorder(new EmptyBorder(10, 10, 10, 10));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(new Color(0, 180, 0));
        return title;
    }

    public JPanel getNavItems() {
        if (Objects.nonNull(navItems)) return navItems;
        navItems = new JPanel();
        navItems.setOpaque(false);
        navItems.setLayout(new GridLayout(10, 1));
        return navItems;
    }

    public <T extends JPanel & ScreenProperties> void createItem(T screen) {
        JButton button = new JButton(screen.getName());
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIcon(screen.getImageIcon());
        button.setBorder(new EmptyBorder(10, 10, 10, 10));
        button.addActionListener(e -> selectPage(screen));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        navItems.add(button);
        pageContentContainer.add(screen, screen.getName());
        navItemAndPainel.put(screen, button);
    }

    public JPanel getFooter() {
        if (Objects.nonNull(footer)) return footer;
        JLabel label = new JLabel(hiperlink);
        label.setBorder(new EmptyBorder(10, 10, 10, 10));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        footer = new JPanel();
        footer.setLayout(new GridLayout(0, 1));
        footer.setOpaque(false);
        footer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        footer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://github.com/HugoJhonathan"));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        footer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("<html><u>" + hiperlink + "</u></html>");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText(hiperlink);
            }
        });


        footer.add(label);
        return footer;
    }

    public void markFirstNavItem() {
        if (pageContentContainer.getComponents().length < 1) {
            return;
        }
        selectPage((Screen) pageContentContainer.getComponent(0));
    }

    public <T extends JPanel & ScreenProperties> void selectPage(T screen) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (Objects.nonNull(frame)) {
            frame.setTitle(screen.getTitle());
        }
        cardLayout.show(pageContentContainer, screen.getName());
        navItemAndPainel.forEach((sc, button) -> {
            button.setBackground(navBarColor);
        });
        Component navItem = navItemAndPainel.get(screen);
        navItem.setBackground(navBarSelected);
    }

}