package src.I07TresEnRaya;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Main {
    // tres en raya
    public static JFrame ventana;
    private static JPanel panelContainer;
    private static CardLayout cardLayout;

    private static final int width = 500;
    private static final int height = 600;
    public static void main(String[] args) throws IOException {
        
        // crear ventana
        ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Tres en raya");
        ventana.setIconImage(ImageIO.read(new File("./Programacion/Java/EjerciciosInterfaces/src/I07TresEnRaya/appIcon.png")));
        ventana.setResizable(false);
        ventana.setSize(width, height);
        ventana.setLocation(200, 100);
        
        // añadir menu
        JMenuBar barraMenu = new JMenuBar();

            JMenu menuPartida = new JMenu("Partida");
                JMenuItem nuevaPartida = new JMenuItem("Nueva PvP");
                nuevaPartida.addActionListener(new ActionListener() {
					@Override public void actionPerformed(ActionEvent e) {
                        mostrarPartidaNueva();
					}
                });
                menuPartida.add(nuevaPartida);

                menuPartida.addSeparator(); // Separador entre elementos

                JMenuItem deshacer = new JMenuItem("Salir al menu");
                deshacer.addActionListener(new ActionListener() {
					@Override public void actionPerformed(ActionEvent e) {
                        mostrarMenuInicio();
					}
                });
                menuPartida.add(deshacer);

            barraMenu.add(menuPartida);
        ventana.setJMenuBar(barraMenu);

        cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout);
        ventana.add(panelContainer);

        panelContainer.add(PanelInicio.newPanel(width, height), "inicio");
        panelContainer.add(PanelPartida.newPanel(width, height), "juego");

        ventana.setVisible(true);
    }
    
    // --------------- MOSTRAR PANELES
    public static void mostrarPartidaNueva(){
        cardLayout.show(panelContainer, "juego");
    }
    public static void mostrarMenuInicio(){
        cardLayout.show(panelContainer, "inicio");
    }
}
