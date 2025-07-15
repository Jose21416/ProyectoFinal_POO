package Lógica;

import Datos.DUsuarios;
import java.sql.*;
import javax.swing.JOptionPane;

public class LEstudiante {
    LConexión ocon = new LConexión();
    Connection cn = ocon.getConnection();
    DUsuarios us = new DUsuarios();
    ResultSet rs;
    
    public DUsuarios mostrarInformacionEstudiante(DUsuarios est){
        PreparedStatement ps = null;
        String sql = "SELECT nombre, correo, contraseña, telefono FROM usuario WHERE usuario = ? AND tipo_usuario = 'estudiante'";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, est.getUsuario());
            rs = ps.executeQuery();
            
            if(rs.next()){
                us.setNombre(rs.getString("nombre"));
                us.setCorreo(rs.getString("correo"));
                us.setContraseña(rs.getString("contraseña"));
                us.setTelefono(rs.getString("telefono")); 
                return us;
            }else{
                JOptionPane.showMessageDialog(null, "Error al mostrar los datos", "Aviso del sistema", 
                        JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error en: " +e.getMessage());
           return null;
        }
    }
    
    public void actualizarCamposEstudiante(DUsuarios est){
        PreparedStatement ps = null;
        String sql = "UPDATE usuario SET correo = ?, telefono = ? WHERE usuario = ? AND tipo_usuario = 'estudiante'";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, est.getCorreo());
            ps.setString(2, est.getTelefono());
            ps.setString(3, est.getUsuario());
            
            int registro = ps.executeUpdate();
            
            if (registro > 0) {
                JOptionPane.showMessageDialog(null, "Datos del usuario actualizados correctamente", "Aviso del sistema",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar","Aviso del sistema",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error en: " +e.getMessage());
        }
    }
}