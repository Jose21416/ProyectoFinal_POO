
package Lógica;

import Datos.DUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class LEgresado {
    LConexión ocon = new LConexión();
    Connection cn = ocon.getConnection();
    DUsuarios us = new DUsuarios();
    ResultSet rs;
    
    public DUsuarios mostrarInformacionEgresado(DUsuarios eg){
        PreparedStatement ps = null;
        String sql = "SELECT nombre, correo, contraseña, telefono FROM usuario WHERE usuario = ? AND tipo_usuario = 'egresado'";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, eg.getUsuario());
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
}
