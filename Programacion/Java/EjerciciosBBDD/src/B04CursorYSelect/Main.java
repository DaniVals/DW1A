package B04CursorYSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
        String sql;

        String apellidoBuscado;

        System.out.println("apellido a buscar");
        apellidoBuscado = teclado.nextLine();
        sql = "SELECT first_name, last_name FROM actor where last_name = '"+apellidoBuscado+"'";

        ResultSet selected = conexion.createStatement().executeQuery(sql);
        int contador=0;
        while (selected.next()) {
            contador++;
            System.out.println(selected.getString("first_name")+"\t"+selected.getString("last_name"));   
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Se han encontrado en total "+contador+" actores");
        
        teclado.close();
    }   
}
