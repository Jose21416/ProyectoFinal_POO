/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lógica;

import Datos.DUsuarios;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LSupervisor {
    
    LConexión con = new LConexión();
    Connection cn = con.getConnection();
    DUsuarios en = new DUsuarios();
    ResultSet rs;
	
    //listarUsuarios en tabla
    public DefaultTableModel listarUsuarios(DUsuarios sup) {
        DefaultTableModel tabla;
        String[] encabezado = {"ID", "Nombre", "Telefono", "Correo", "Usuario", "Contraseña", "Tipo de Usuario", "Estado"};
        String[] registro = new String[8];

        tabla = new DefaultTableModel(null, encabezado);

        String sql = "SELECT id_usuario, nombre, telefono, correo, usuario, contraseña, tipo_usuario, estado "
                + "FROM usuario WHERE usuario LIKE ? ORDER BY nombre";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + sup.getUsuario() + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = String.valueOf(rs.getInt("id_usuario"));
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("telefono");
                registro[3] = rs.getString("correo");
                registro[4] = rs.getString("usuario");
                registro[5] = rs.getString("contraseña");
                registro[6] = rs.getString("tipo_usuario");
                registro[7] = rs.getString("estado");

                tabla.addRow(registro);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar usuario: " + e.getMessage());
        }
        return tabla;
    }

    // Eliminar todos los usuarios registrados menos administradores y supervisores
    public boolean eliminarUsuarios() {
        String sql = "DELETE FROM usuario WHERE tipo_usuario NOT IN ('administrador', 'supervisor')";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            int filas = ps.executeUpdate();

            if (filas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en: " +e.getMessage());
            return false;
        }
    }
    
}
