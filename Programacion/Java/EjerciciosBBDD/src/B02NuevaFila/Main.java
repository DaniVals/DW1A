package B02NuevaFila;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conexion;
        conexion = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sakila", // la url de la conexion (no toques nada menos el nombre y el puerto si lo has cambiado)
            "root", //el usuario (por defecto root
            "1042" // la contraseña
        );

        Scanner teclado = new Scanner(System.in);

        String nombre,apellido;

        System.out.println("nuevo nombre");
        nombre = teclado.nextLine();
        System.out.println("nuevo apellido");
        apellido = teclado.nextLine();

        String sql;
        
        // '1', 'PENELOPE', 'GUINESS', '2006-02-15 04:34:33'

        sql = "INSERT INTO actor(first_name, last_name) VALUES ('"+nombre+"', '"+apellido+"')";
        System.out.println(sql);
        // execute update se usa para todo 
        // ! MENOS para select
        conexion.createStatement().executeUpdate(sql); 
        
        teclado.close();
    }   
}
