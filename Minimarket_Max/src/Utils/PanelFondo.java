package Utils;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class PanelFondo implements Border {

    public BufferedImage back;

    public PanelFondo() {
        try {
            URL imagePath = new URL(getClass().getResource("/img/fondo-principal.jpg").toExternalForm());
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {
        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (back != null) {
            g.drawImage(back, 0, 0, width, height, null);
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

}
