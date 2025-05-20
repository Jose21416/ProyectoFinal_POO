
package Lógica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LConexión {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/proyectofinal?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root"; // <-- Aquí está el cambio

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("✅ Conexión exitosa a MySQL!");

            conexion.close(); 
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos:");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver JDBC no encontrado:");
            e.printStackTrace();
        }
    }
    
}
