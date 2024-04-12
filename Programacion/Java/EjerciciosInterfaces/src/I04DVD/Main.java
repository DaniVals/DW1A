package src.I04DVD;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {
    private static final int width = 300;
    private static final int height = 150;
    private static final double vel = 0.000005;
    private static final Color backgroundColor = new Color(0, 0, 0, 0);
    private static boolean activo = true;
    public static void main(String[] args) throws IOException {
        
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("DVD");
        ventana.setIconImage(ImageIO.read(new File("./Programacion/Java/EjerciciosInterfaces/src/I04DVD/DVD.png ")));
        ventana.setResizable(false);
        ventana.setSize(width, height);
        ventana.setLocation(0, 0);
        ventana.addKeyListener(new KeyListener() {

            @Override public void keyTyped(KeyEvent e) {}
            @Override public void keyReleased(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    ventana.dispose(); // Cierra la ventana
                    activo = false; //detiene el bucle
                }
            }
        });
        // poner ventana sin bordes y transparente
        ventana.setUndecorated(true);
        ventana.setBackground(new Color(0, 0, 0, 0));
        
        
        JPanel panel = new JPanel();
        panel.setLayout(null); // esto indica que las coordenadas son absolutas
        panel.setBackground(backgroundColor);
        
        if (true) {
            try {
                // Cargar la imagen desde el proyecto
                BufferedImage imagen = ImageIO.read(
                    new File("./Programacion/Java/EjerciciosInterfaces/src/I04DVD/DVD.png"));
    
                Image imagenEscalada = imagen.getScaledInstance(width, height, Image.SCALE_SMOOTH);


                // Crear un ImageIcon a partir de la imagen cargada
                ImageIcon imagenIcono = new ImageIcon(imagenEscalada);
                JLabel etiquetaImagen = new JLabel(imagenIcono);
                etiquetaImagen.setBounds(0, 0, width, height);
                panel.add(etiquetaImagen);
    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        

        ventana.add(panel);
        ventana.setVisible(true);



        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xMax = (int)screenSize.getWidth()-width;
        int yMax = (int)screenSize.getHeight()-height;
        double ix=0;
        double iy=0;
        boolean xvel = true, yvel = true;
        while (activo) {
            if (xvel) {
                ix+=vel;
                if (xMax<=ix) {
                    xvel = false;
                }
            }else{
                ix-=vel;
                if (ix<=0) {
                    xvel = true;
                }
            }
            if (yvel) {
                iy+=vel;
                if (yMax<=iy) {
                    yvel = false;
                }
            }else{
                iy-=vel;
                if (iy<=0) {
                    yvel = true;
                }
            }
            ventana.setLocation((int)ix, (int)iy);
        }
    }
}
