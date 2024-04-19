package B00Pruebas;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws Exception {    
        Connection conexion;

        conexion = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sakila", // la url de la conexion (no toques nada menos el nombre y el puerto si lo has cambiado)
            "root", //el usuario (por defecto root
            "1042" // la contraseña
        );
        
        conexion.createStatement();
    }
}
