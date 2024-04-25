package B06BuscarActoresConPeli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","1042");
        String sql = "SELECT ac.first_name ,COUNT(fi.actor_id) FROM sakila.actor ac JOIN sakila.film_actor fi ON ac.actor_id = fi.actor_id group by fi.actor_id order by fi.actor_id;";

        ResultSet selected = conexion.createStatement().executeQuery(sql);
        String mayorActor="no se encontraron datos", actor;
        int mayorActorPelis = 0, pelis;
        while (selected.next()) {
            actor = selected.getString("ac.first_name");
            pelis = selected.getInt("COUNT(fi.actor_id)");
            if (mayorActorPelis<pelis) {
                mayorActorPelis = pelis;
                mayorActor = actor;
            }
            System.out.println(actor+"\t"+pelis);   
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Mayor actor: "+mayorActor+" con "+mayorActorPelis);
    }   
}