package src.I07TresEnRaya;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPartida {
    static JButton boton[][] = new JButton[3][3];
    public static JPanel newPanel(int width, int height){
        JPanel panelJuego = new JPanel();
        panelJuego.setLayout(null);

        // BOTONES
        final int widthBoton  = 50;
        final int heightBoton = 50;
        final int posX  = width/2 - (widthBoton*3/2);
        final int posY = height/2 - (heightBoton*3/2);

        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton[i].length; j++) {
                boton[i][j] = new JButton();
                boton[i][j].setBounds(posX + widthBoton*i, posY + heightBoton*j, widthBoton, heightBoton);
                panelJuego.add(boton[i][j]);
            }
        }
        boton[0][0].addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                colocarFicha(0, 0);
            }
        });

        return panelJuego;
    }

    public static void colocarFicha(int x, int y){

    }
}
