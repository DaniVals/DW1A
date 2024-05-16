package Ej2;

import java.sql.SQLException;

import javax.swing.JFrame;

public class Main {
    public static final int width=500;
    public static final int height=300;
    public static final String DIR_ARCHIVO_PAISES = "Programacion/Java/ExTerceraEv/src/paises.txt";
    public static void main(String[] args) throws SQLException {
        
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Agenda BBDD");
        ventana.setResizable(false);
        ventana.setSize(width, height);

        // para ponerla en el medio de la pantalla mas o menos
        ventana.setLocation(500, 300);

        ventana.add(Interfaz.getPanel());

        ventana.setVisible(true);
    }
}
