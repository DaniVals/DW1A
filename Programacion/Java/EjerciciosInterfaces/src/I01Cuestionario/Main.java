package src.I01Cuestionario;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {


    public static JButton boton1;
    public static JFrame ventana;
    public static JTextField campoTexto;
    public static JLabel texto;
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

        // BOTON
        boton1 = new JButton("Boton 1");
        boton1.setLocation(200, 50);
        boton1.setSize(100, 50);
        boton1.addMouseListener(new EventoMouse());
        panel.add(boton1);
        
        // INPUT DE TEXTO
        campoTexto = new JTextField();
        campoTexto.setBounds(50, 75, 150, 30); // Establecer la posición y el tamaño del campo de texto
        panel.add(campoTexto);

        // TEXTO
        texto = new JLabel();
        texto.setBounds(50, 200, 1000, 50);
        texto.setFont(new Font("Arial", Font.PLAIN, 12)); // Establecer la fuente y el tamaño del texto
        panel.add(texto);

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

    public static void CambiarTextoConCuestionario(){
        texto.setText("Has escrito: "+campoTexto.getText());
    }
    // una calculadora (dos inputs de texto y cuatro botones) ademas que avise de que no se introduzca ambos valores "debe rellenar ambos campos"
}
