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


        // BOTON de inicio
        JButton boton = new JButton("Empezar partida multijugador local");
        final int widthBoton = 300;
        final int heightBoton = 40;
        boton.setBounds(width/2 - widthBoton/2, height/2 - heightBoton/2, widthBoton, heightBoton);
        boton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
                Main.mostrarPartidaNueva();
			}
        });
        panelInicio.add(boton);

        // BOTON de salir
        boton = new JButton("Salir");
        final int widthBoton2 = 100;
        final int heightBoton2 = 40;
        boton.setBounds(width/2 - widthBoton2/2, height/2 - heightBoton/2 + 50, widthBoton2, heightBoton2);
        boton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
                Main.ventana.dispose();
			}
        });
        panelInicio.add(boton);

        return panelInicio;
    }
}
