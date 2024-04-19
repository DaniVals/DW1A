package src.I07TresEnRaya;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.I07TresEnRaya.PanelPartidaMaquina.Starts;

public class PanelInicio {
    
    public static JPanel newPanel(int width, int height){
        JPanel panelInicio = new JPanel();
        panelInicio.setLayout(null);

        // FOTO
        try {
            // Cargar la imagen desde el proyecto
            BufferedImage imagen = ImageIO.read(
                new File("./Programacion/Java/EjerciciosInterfaces/src/I07TresEnRaya/appIcon.png"));

            // Crear un ImageIcon a partir de la imagen cargada
            ImageIcon imagenIcono = new ImageIcon(imagen);
            JLabel etiquetaImagen = new JLabel(imagenIcono);
            etiquetaImagen.setBounds(0, 0, width, height/3);
            panelInicio.add(etiquetaImagen);

        } catch (IOException e) {
            e.printStackTrace();
        }


        // BOTON de partida multiplayer
        JButton boton = new JButton("Empezar partida multijugador local");
        final int widthBoton = 300;
        final int heightBoton = 40;
        boton.setBounds(width/2 - widthBoton/2, height/2 - heightBoton/2, widthBoton, heightBoton);
        boton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
                Main.mostrarPartidaNuevaMultijugador();
			}
        });
        panelInicio.add(boton);

        // BOTON de partida IA
        final int widthBoton3 = 300;
        boton = new JButton("IA Facil");
        boton.setBounds(width/2 - widthBoton3/2 + widthBoton3/3*0, height/2 - heightBoton/2 + 50, widthBoton3/3, heightBoton);
        boton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
                Main.mostrarPartidaNuevaMaquina(Starts.J1);
			}
        });
        panelInicio.add(boton);
        boton = new JButton("IA Normal");
        boton.setBounds(width/2 - widthBoton3/2 + widthBoton3/3*1, height/2 - heightBoton/2 + 50, widthBoton3/3, heightBoton);
        boton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
                Main.mostrarPartidaNuevaMaquina(Starts.Random);
			}
        });
        panelInicio.add(boton);
        boton = new JButton("IA Dificil");
        boton.setBounds(width/2 - widthBoton3/2 + widthBoton3/3*2, height/2 - heightBoton/2 + 50, widthBoton3/3, heightBoton);
        boton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
                Main.mostrarPartidaNuevaMaquina(Starts.J2);
			}
        });
        panelInicio.add(boton);

        // BOTON de salir
        boton = new JButton("Salir");
        final int widthBoton2 = 100;
        final int heightBoton2 = 40;
        boton.setBounds(width/2 - widthBoton2/2, height/2 - heightBoton/2 + 100, widthBoton2, heightBoton2);
        boton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
                Main.ventana.dispose();
			}
        });
        panelInicio.add(boton);

        return panelInicio;
    }
}
