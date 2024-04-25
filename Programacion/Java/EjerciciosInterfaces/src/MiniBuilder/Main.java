package src.MiniBuilder;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    public static JButton botonActual;
    public static JFrame ventana;

    public static ArrayList<Bounder> creados = new ArrayList<Bounder>() ;
    public static PrintWriter out;
    public static void main(String[] args) throws IOException {
        
        //crear la ventana
        ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Construir");
        ventana.setResizable(false);
        ventana.setSize(new Dimension(700, 500));

        
        
        
        //crear un panel
        JPanel panel = new JPanel();
        panel.setLayout(null); // esto indica que las coordenadas son absolutas
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("creado archivo");
                try {
                    escribir();
                    System.out.println("did archivo");
                } catch (IOException e1) {
                    System.out.println("err archivo");
                    e1.printStackTrace();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                botonActual = new JButton();
                botonActual.setLocation(e.getX(), e.getY());
                panel.add(botonActual);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                botonActual.setSize(e.getX()-botonActual.getX(),e.getY()-botonActual.getY());
                botonActual.setVisible(true);
                creados.add(new Bounder(botonActual.getX(), botonActual.getY(), botonActual.getWidth(), botonActual.getHeight()));
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        // Agregar el panel a la ventana y la muestra
        ventana.add(panel);
        ventana.setVisible(true);
    }

    public static void escribir() throws IOException{
        // crear archivo
        for (Bounder bounder : creados) {
            System.out.println(bounder.funcion());
        }
    }
}
