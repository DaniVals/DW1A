package src.I00Pruebas;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {


    public static JButton boton1;
    public static JFrame ventana;
    public static void main(String[] args) {
        
        //crear la ventana
        ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Pruebas");
        ventana.setResizable(false);
        ventana.setSize(new Dimension(700, 500));
        CambiarVentanaAlCentro();


        //crear un panel
        JPanel panel = new JPanel();
        panel.setLayout(null); // esto indica que las coordenadas son absolutas

        boton1 = new JButton("Boton 1");
        boton1.setSize(100, 50);
        boton1.addKeyListener(new EventoTeclas());
        boton1.addMouseListener(new EventoMouse());
        boton1.setLocation(50, 50);
        panel.add(boton1);
        

        // Agregar el panel a la ventana y la muestra
        ventana.add(panel);
        ventana.setVisible(true);
        System.out.println("Se acabo el main");        
    }

    public static void CambiarVentanaAlCentro(){
        // Obtener el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Calcular la posición para centrar la ventana
        int centerX = (int) ((screenSize.getWidth() - ventana.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - ventana.getHeight()) / 2);
        
        // Establecer la posición de la ventana
        ventana.setLocation(centerX, centerY);
    }

    public static void MoverBotonRandom(){
        int nuevaX, nuevaY;

        nuevaX = (int)(Math.random() * (ventana.getWidth() - boton1.getWidth()));
        nuevaY = (int)(Math.random() * (ventana.getHeight() - boton1.getHeight()));

        Main.boton1.setLocation(nuevaX, nuevaY);
    }
}
