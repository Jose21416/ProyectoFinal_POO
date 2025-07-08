package Lógica;

import Datos.DUsuarios;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
                JOptionPane.showMessageDialog(null, "No se encontro el usuario (Esta inactivo o el tipo de usuario no es el correcto)", "Aviso del sistema",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error en: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en: " + e.getMessage());
        }
        return false;

    }

    public boolean crearUsuario(String usuario, String nombre, String correo, String contraseña, String telefono, String tipoUsuario) {
        String sql = "{CALL CrearUsuario(?, ?, ?, ?, ?, ?)}";

        try (CallableStatement cs = cn.prepareCall(sql)) {
            cs.setString(1, usuario);
            cs.setString(2, nombre);
            cs.setString(3, correo);
            cs.setString(4, contraseña);
            cs.setString(5, telefono);
            cs.setString(6, tipoUsuario.toLowerCase());

            boolean tieneResultado = cs.execute();

            if (tieneResultado) {
                ResultSet rs = cs.getResultSet();
                if (rs.next()) {
                    int id = rs.getInt("id_usuario");
                    String mensaje = rs.getString("mensaje");
                    return true;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar el procedimiento: " + e.getMessage());
        }

        return false;
    }

    public DefaultTableModel mostrarUsuarios(DUsuarios dts) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Telefono", "Correo", "Usuario", "Contraseña", "Tipo de Usuario", "Estado"};
        String[] registro = new String[8];

        modelo = new DefaultTableModel(null, titulos);

        String sqlSinFiltro = "{CALL MostrarListaUsuarios()}";
        String sqlConFiltro = "SELECT id_usuario, nombre, telefono, correo, usuario, contraseña, tipo_usuario, estado "
                + "FROM usuario WHERE usuario LIKE ? ORDER BY nombre";

        try {
            PreparedStatement pst;

            if (dts.getUsuario() == null || dts.getUsuario().trim().isEmpty()) {
                // Usar procedimiento
                CallableStatement cs = cn.prepareCall(sqlSinFiltro);
                ResultSet rs = cs.executeQuery();

                while (rs.next()) {
                    registro[0] = String.valueOf(rs.getInt("id_usuario"));
                    registro[1] = rs.getString("nombre");
                    registro[2] = rs.getString("telefono");
                    registro[3] = rs.getString("correo");
                    registro[4] = rs.getString("usuario");
                    registro[5] = rs.getString("contraseña");
                    registro[6] = rs.getString("tipo_usuario");
                    registro[7] = rs.getString("estado");

                    modelo.addRow(registro);
                }

            } else {
                // Usar consulta con filtro
                pst = cn.prepareStatement(sqlConFiltro);
                pst.setString(1, "%" + dts.getUsuario() + "%");
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    registro[0] = String.valueOf(rs.getInt("id_usuario"));
                    registro[1] = rs.getString("nombre");
                    registro[2] = rs.getString("telefono");
                    registro[3] = rs.getString("correo");
                    registro[4] = rs.getString("usuario");
                    registro[5] = rs.getString("contraseña");
                    registro[6] = rs.getString("tipo_usuario");
                    registro[7] = rs.getString("estado");

                    modelo.addRow(registro);
                }
            }

            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar usuarios: " + e.getMessage());
            return modelo;
        }
    }

    public String editarUsuarios(DUsuarios misUsuarios) {

        String msg = null;

        System.out.println("ID a editar: " + misUsuarios.getId_usuario());
        System.out.println("Usuario: " + misUsuarios.getUsuario());
        System.out.println("Correo: " + misUsuarios.getCorreo());

        try {

            CallableStatement cst = cn.prepareCall("{ call ActualizarUsuario(?,?,?,?,?,?,?,?)}");
            cst.setInt(1, misUsuarios.getId_usuario());
            cst.setString(2, misUsuarios.getNombre());
            cst.setString(3, misUsuarios.getTelefono());
            cst.setString(4, misUsuarios.getCorreo());
            cst.setString(5, misUsuarios.getUsuario());
            cst.setString(6, misUsuarios.getContraseña());
            cst.setString(7, misUsuarios.getTipoUsuario().name());
            cst.setString(8, misUsuarios.getEstado().name());

            cst.executeUpdate();

            msg = "Se actualizó de forma correcta";
        } catch (Exception ex) {

            ex.printStackTrace();

        }

        return msg;

    }

    public String eliminarUsuarios(DUsuarios misUsuarios) {

        String msg = null;

        try {

            CallableStatement cst = cn.prepareCall("{ call EliminarUsuario(?)}");
            cst.setInt(1, misUsuarios.getId_usuario());
            cst.executeUpdate();
            msg = "Se eliminó de forma correcta";
        } catch (Exception ex) {

            ex.printStackTrace();

        }

        return msg;

    }

}
