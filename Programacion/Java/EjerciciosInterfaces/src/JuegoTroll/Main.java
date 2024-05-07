package src.JuegoTroll;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main {

    public static JFrame ventana;
    public static JLabel texto;
    
    public static boolean activo = true;

    public static void main(String[] args) {
        
        //crear la ventana
        ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("por favor, espere un momento");
        ventana.setResizable(false);
        ventana.setSize(new Dimension(700, 500));
        CambiarVentanaAlCentro();


        ventana.addKeyListener(new KeyListener() {

            @Override public void keyTyped(KeyEvent e) {
            }

            @Override public void keyPressed(KeyEvent e) {
                perder();
            }

            @Override public void keyReleased(KeyEvent e) {
            }
            
        });

        ventana.addMouseListener(new MouseListener() {

            @Override public void mouseClicked(MouseEvent e) {
            }

            @Override public void mousePressed(MouseEvent e) {
                perder();
            }

            @Override public void mouseReleased(MouseEvent e) {
            }

            @Override public void mouseEntered(MouseEvent e) {
            }
            
            @Override public void mouseExited(MouseEvent e) {
            }
            
        });


        //crear un panel
        JPanel panel = new JPanel();
        panel.setLayout(null); // esto indica que las coordenadas son absolutas

        texto = new JLabel();
        texto.setBounds(310, 200, 100, 50);
        panel.add(texto);

        // Agregar el panel a la ventana y la muestra
        ventana.add(panel);
        ventana.setVisible(true);
        long horaInicio = System.currentTimeMillis();
        final int SECS_PARA_GANAR = 30;
        while (activo) {
            if (horaInicio+SECS_PARA_GANAR*1000 < System.currentTimeMillis()) {
                ganar();
            }
        }
    }

    public static void ganar(){
        texto.setText("ganaste");
        activo = false;
    }
    public static void perder(){
        texto.setText("perdiste");
        activo = false;
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
}