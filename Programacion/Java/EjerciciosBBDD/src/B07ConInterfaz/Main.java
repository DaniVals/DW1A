package B07ConInterfaz;

import java.sql.SQLException;

import javax.swing.JFrame;

public class Main {

    public static final int width=900;
    public static final int height=700;
    public static void main(String[] args) throws SQLException {
        
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Agenda BBDD");
        ventana.setResizable(false);
        ventana.setSize(width, height);

        ventana.add(Interfaz.getPanel());

        ventana.setVisible(true);
    }
}
