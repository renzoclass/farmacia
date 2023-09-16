/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 *
 * @author Labor
 */
public class ImagenFondo implements Border {

    public BufferedImage back;

    public ImagenFondo() {
        try {
            URL imagePath = new URL(getClass().getResource("/Imagenes/FARMACIA3.jpg").toString());
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {
        }
    }

    public void paintBorder(Component c, Graphics g, int y, int x, int width, int height) {
        g.drawImage(back, (y + (width - back.getWidth()) / 2), (x + (height - back.getHeight()) / 2), null);
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    public boolean isBorderOpaque() {
        return false;
    }

}
