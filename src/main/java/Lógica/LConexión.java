package Lógica;
import java.sql.*;
import javax.swing.JOptionPane;

public class LConexión {
    
    private Connection cn;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    // URL corregida con allowPublicKeyRetrieval=true
    private final String url = "jdbc:mysql://localhost:3306/proyectofinal?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final String usuario = "root";
    private final String clave = "1234";
    
    public Connection getConnection() {
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: Driver no encontrado - " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión SQL: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
        return cn;
    }
    
    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (cn != null && !cn.isClosed()) {
                cn.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar conexión: " + e.getMessage());
        }
    }
    
    // Verificar la conexión
    public static void main(String[] args) {
        LConexión ocon = new LConexión();
        Connection conexion = ocon.getConnection();
        
        if (conexion != null) {
            System.out.println("Conectado a: " + conexion);
            System.out.println("Ok - Conexión exitosa");
        } else {
            System.out.println("Error - No se pudo conectar");
        }
        
        // Cerrar conexión al finalizar
        ocon.cerrarConexion();
    }
}