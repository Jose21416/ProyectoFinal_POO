
package Lógica;

import java.sql.*;
import javax.swing.JOptionPane;


public class LConexión {
    
    private Connection cn;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/proyectofinal?useSSL=false&serverTimezone=UTC";
    private final String usuario = "root";
    private final String clave = "root";

    public Connection getConnection() {
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
        return cn;
    }

    // Verificar la conexión
    public static void main(String[] args) {
        LConexión ocon = new LConexión();
        System.out.println("Conectado a: " + ocon.getConnection());
        System.out.println("Ok");
    }

    
    
}
