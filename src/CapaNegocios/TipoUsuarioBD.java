/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocios;

import CapaConexion.Conexion;
import CapaDatos.TipoUsuario;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Labor
 */
public class TipoUsuarioBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarTipoUsuario() {

        DefaultTableModel tabla_temporal;

        String[] cabecera = {"CODIGO", "NOMBRE"};
        String[] registros = new String[2];
        tabla_temporal = new DefaultTableModel(null, cabecera);
        sql = "SELECT idtipousuario,tuNombre FROM tipousuario";

        try {

            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idtipousuario");
                registros[1] = rs.getString("tuNombre");


                tabla_temporal.addRow(registros);
            }
            return tabla_temporal;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar Tipo Usuario...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public boolean resgistarTipoUsuario(TipoUsuario tu) {
        sql = "INSERT INTO tipousuario(idtipousuario,tuNombre) VALUES(0,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, tu.getTuNombre());

            pst.executeUpdate();

            return true;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "PROBLEMAS  AL REGISTRAR ", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public boolean modificarTipoUsuario(TipoUsuario tu) {

        sql = "UPDATE tipousuario SET tuNombre=? WHERE idtipousuario=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, tu.getTuNombre());
            pst.setInt(2, tu.getIdtipousuario());

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean eliminarTipoUsuario(TipoUsuario tu) {

        sql = "DELETE  FROM tipousuario WHERE idtipousuario=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, tu.getIdtipousuario());
            
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas Al Eliminar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
