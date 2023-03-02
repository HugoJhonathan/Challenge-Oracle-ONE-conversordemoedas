package GUI.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Util {

    static public ImageIcon getImageIcon(String path) {
        try {
            return new ImageIcon(ClassLoader.getSystemResource(path));
        } catch (NullPointerException np) {
            System.out.println("ERROR:");
            System.out.println(np.getMessage());
            return null;
        }
    }

    public static Image getImage(String path) {
        Image image = null;
        URL url = ClassLoader.getSystemResource(path);
        if (Objects.nonNull(url)) {
            try {
                image = ImageIO.read(url);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Image not found: " + path);
        }
        return image;
    }

    public static void increaseFont(Component component, float size) {
        Font font = component.getFont();
        component.setFont(font.deriveFont(size));
    }

}
