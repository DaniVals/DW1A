package B01CambiarApellido;

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

        String apellidoBuscado,apellidoNuevo;

        System.out.println("apellido a buscar");
        apellidoBuscado = teclado.nextLine();
        System.out.println("nuevo apellido");
        apellidoNuevo = teclado.nextLine();

        String sql;
        
        // '1', 'PENELOPE', 'GUINESS', '2006-02-15 04:34:33'

        sql = "update actor set last_name = '"+apellidoNuevo+"' where last_name = '"+apellidoBuscado+"'";
        System.out.println(sql);
        conexion.createStatement().executeUpdate(sql); // devuelve cuantas filas se han modificado
        
        teclado.close();
    }   
}
