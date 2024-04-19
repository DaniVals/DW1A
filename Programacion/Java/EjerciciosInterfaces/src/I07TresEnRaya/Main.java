package src.I07TresEnRaya;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import src.I07TresEnRaya.PanelPartidaMaquina.Starts;

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
                        mostrarPartidaNuevaMultijugador();
					}
                });
                menuPartida.add(nuevaPartida);

                JMenuItem nuevaPartida2 = new JMenuItem("Nueva IA Facil");
                nuevaPartida2.addActionListener(new ActionListener() {
					@Override public void actionPerformed(ActionEvent e) {
                        mostrarPartidaNuevaMaquina(Starts.J1);
					}
                });
                menuPartida.add(nuevaPartida2);

                JMenuItem nuevaPartida3 = new JMenuItem("Nueva IA Normal");
                nuevaPartida3.addActionListener(new ActionListener() {
					@Override public void actionPerformed(ActionEvent e) {
                        mostrarPartidaNuevaMaquina(Starts.Random);
					}
                });
                menuPartida.add(nuevaPartida3);

                JMenuItem nuevaPartida4 = new JMenuItem("Nueva IA Dificil");
                nuevaPartida4.addActionListener(new ActionListener() {
					@Override public void actionPerformed(ActionEvent e) {
                        mostrarPartidaNuevaMaquina(Starts.J2);
					}
                });
                menuPartida.add(nuevaPartida4);

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
        PanelPartidaMultijugador.newPanel(width, height);
        panelContainer.add(PanelPartidaMultijugador.panelJuego, "juego");
        PanelPartidaMaquina.newPanel(width, height);
        panelContainer.add(PanelPartidaMaquina.panelJuego, "juego2");

        ventana.setVisible(true);
    }
    
    // --------------- MOSTRAR PANELES
    public static void mostrarPartidaNuevaMultijugador(){
        PanelPartidaMultijugador.resetPanel();
        cardLayout.show(panelContainer, "juego");
    }
    public static void mostrarPartidaNuevaMaquina(Starts ws){
        PanelPartidaMaquina.resetPanel(ws);
        cardLayout.show(panelContainer, "juego2");
    }
    public static void mostrarMenuInicio(){
        cardLayout.show(panelContainer, "inicio");
    }
}
