package Lógica;

import Datos.DUsuarios;
import java.sql.*;
import javax.swing.JOptionPane;

public class LUsuarios {
    
    LConexión con = new LConexión();
    Connection cn = con.getConnection();
    DUsuarios en = new DUsuarios();
    ResultSet rs;

    public boolean validarLogin(DUsuarios usu) {
        PreparedStatement ps = null;
        String sql = "select usuario, contraseña, estado, tipo_usuario from usuario where usuario = ? and contraseña = ? and estado = ? and tipo_usuario = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getContraseña());
            ps.setString(3, usu.getEstado().toString().toLowerCase());
            ps.setString(4, usu.getTipoUsuario().toString().toLowerCase());
            rs = ps.executeQuery();

            if (rs.next()) {
                en.setUsuario(rs.getString("usuario"));
                en.setContraseña(rs.getString("contraseña"));
                en.setEstado(DUsuarios.Estado.valueOf(rs.getString("estado").toUpperCase()));
                en.setTipoUsuario(DUsuarios.TipoUsuario.valueOf(rs.getString("tipo_usuario").toUpperCase()));

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el usuario (Esta inactivo o el tipo de usuario no es el correcto)" ,"Aviso del sistema", 
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error en: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en: " + e.getMessage());
        }
        return false;

    }
    
}
