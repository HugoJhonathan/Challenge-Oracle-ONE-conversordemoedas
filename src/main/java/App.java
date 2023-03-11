import GUI.Window;
import com.formdev.flatlaf.FlatDarkLaf;
import service.MoneyService;

import javax.swing.*;

public class App {

    public static void main(String[] args) throws Exception {
        FlatDarkLaf.setup();
        SwingUtilities.invokeLater(Window::new);
        MoneyService.updateDollarEquivalenceOfCoins();
    }

}