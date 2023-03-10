import GUI.Window;
import com.formdev.flatlaf.FlatDarkLaf;
import service.MoneyService;

import javax.swing.*;

public class App {

    public static void main(String[] args) throws Exception {
        MoneyService.updateDollarEquivalenceOfCoins();
        FlatDarkLaf.setup();
        SwingUtilities.invokeLater(Window::new);
    }

}