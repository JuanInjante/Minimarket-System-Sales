/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author juan_
 */
public class Utileria {

    private static final String RUTA_LOGO = "src/Img/icon-shop.png";

    public static Image Icono() {
        Image icon = new ImageIcon(RUTA_LOGO).getImage();
        return icon;
    }

    public static Icon IconoImg() {
        ImageIcon img = new ImageIcon(RUTA_LOGO);
        return img;
    }

    public static String ConvertirFecha(Date fecha) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

        String cadena = "";
        try {
            cadena = sd.format(fecha);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cadena;
    }   
}