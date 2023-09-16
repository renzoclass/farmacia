/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Labor
 */
public class Conexion {

    private static String clase = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3307/farmacia?serverTimezone=UTC";
    private static String usuario = "root";
    private String clave = "123456";

    public Conexion() {

    }

    public Connection conectar() {
        Connection link = null;
        try {
            Class.forName(clase);
            link = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }

}
