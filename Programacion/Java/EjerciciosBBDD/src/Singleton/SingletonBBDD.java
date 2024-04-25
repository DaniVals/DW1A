package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonBBDD {
    private static Connection conex;


    private SingletonBBDD(String BBDD, String username, String password) throws SQLException {
        // "jdbc:mysql://localhost:3306/sakila"
        conex = DriverManager.getConnection( BBDD,username,password);
    }

    public static void createConnectionAsRoot(String BBDD) throws SQLException{
        if (conex == null) {
            new SingletonBBDD(BBDD, "root", "1042");
        }
    }

    public static void createConnection(String BBDD, String username, String password) throws SQLException{
        if (conex == null) {
            new SingletonBBDD(BBDD, username, password);
        }
    }

    public static Connection getConnection() {
        return conex;
    }
}
