package B05CSVinator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Connection conexion;
        conexion = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sakila", // la url de la conexion (no toques nada menos el nombre y el puerto si lo has cambiado)
            "root", //el usuario (por defecto root
            "1042" // la contraseña
        );
        PrintWriter out = null;
        
        out = new PrintWriter(new FileWriter("Programacion/Java/EjerciciosBBDD/src/B05CSVinator/actores.csv"));
        
        String sql, filaCSV;
        sql = "SELECT * FROM actor";
        ResultSet selected = conexion.createStatement().executeQuery(sql);
        while (selected.next()) {
            filaCSV =  selected.getInt("actor_id")+", "+selected.getString("first_name")+", "+selected.getString("last_name")+", "+selected.getDate("last_update");   
            System.out.println(filaCSV);
            out.println(filaCSV);
        }

        System.out.println(selected.getMetaData().toString());

        out.close();
    }   
}
