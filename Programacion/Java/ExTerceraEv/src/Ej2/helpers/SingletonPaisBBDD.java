package Ej2.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonPaisBBDD {
    
    private static Connection conex;

    private static void createConnection(){
        try {
            conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "1042");
        } catch (SQLException e) {
            conex = null;
        }

    }
    
    public static Connection getConnection() {
        if (conex == null) {
            createConnection();
        }
        return conex;
    }
}
