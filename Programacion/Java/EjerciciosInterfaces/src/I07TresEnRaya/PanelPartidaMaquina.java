package src.I07TresEnRaya;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPartidaMaquina {
    public enum Starts{
        J1,
        J2,
        Random
    }
    public static JPanel panelJuego = new JPanel();
    static JButton boton[][] = new JButton[3][3];
    static JLabel textoLabel = new JLabel();

    private static final String iconoJ1 = "x"; 
    private static final String iconoJ2 = "i"; 

    public static void newPanel(int width, int height){
        panelJuego.setLayout(null);

        // BOTONES
        final int widthBoton  = 100;
        final int heightBoton = 100;
        final int posX  = width/2 - (widthBoton*3/2);
        final int posY = height/2 - (heightBoton*3/2);

        textoLabel.setBounds(posX, posY - 50, widthBoton*3, 25);
        panelJuego.add(textoLabel);
        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton[i].length; j++) {
                boton[i][j] = new JButton();
                boton[i][j].setBounds(posX + widthBoton*i, posY + heightBoton*j, widthBoton, heightBoton);
                boton[i][j].setFont(new Font("arial",Font.BOLD,heightBoton/3));
                panelJuego.add(boton[i][j]);
            }
        }
        boton[0][0].addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                colocarFicha(0, 0);
            }
        });
        boton[0][1].addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                colocarFicha(0, 1);
            }
        });
        boton[0][2].addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                colocarFicha(0, 2);
            }
        });
        boton[1][0].addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                colocarFicha(1, 0);
            }
        });
        boton[1][1].addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                colocarFicha(1, 1);
            }
        });
        boton[1][2].addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                colocarFicha(1, 2);
            }
        });
        boton[2][0].addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                colocarFicha(2, 0);
            }
        });
        boton[2][1].addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                colocarFicha(2, 1);
            }
        });
        boton[2][2].addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                colocarFicha(2, 2);
            }
        });
        resetPanel(Starts.J1);
    }

    public static void resetPanel(Starts whoStarts){
        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton[i].length; j++) {
                boton[i][j].setText("");
            }
        }
        switch (whoStarts) {
            case J2:
                textoLabel.setText("Le toca al jugador "+iconoJ2);
                movimientoIA();
            break;
            case Random:
                if (Math.random()<0.5) {
                    textoLabel.setText("Le toca al jugador "+iconoJ2);
                    movimientoIA();
                }
            break;

            case J1:
            default:
            break;
        }
        textoLabel.setText("Le toca al jugador "+iconoJ1);
    }

    public static void colocarFicha(int x, int y){
        if (detectarGanador(iconoJ1) || detectarGanador(iconoJ2)) {
            return;
        }
        if (boton[x][y].getText().equals("")) {
            
            boton[x][y].setText(iconoJ1);
            textoLabel.setText("Le toca al jugador "+iconoJ2);
            
            if (detectarGanador(iconoJ1)) {
                textoLabel.setText("Ha ganado el jugador "+iconoJ1);
            }else{
                movimientoIA();
                textoLabel.setText("Le toca al jugador "+iconoJ1);

                if (detectarGanador(iconoJ2)) {
                    textoLabel.setText("Ha ganado el jugador "+iconoJ2);
                }else if (tableroLLeno()) {
                    textoLabel.setText("Empate");
                }
            }
            
        }else{
            System.out.println("aviso de casilla ocupada");
        }
    }
    public static boolean detectarGanador(String ganador){
        for (int i = 0; i < boton.length; i++) {
            if(boton[i][0].getText().equals(ganador) && boton[i][1].getText().equals(ganador) && boton[i][2].getText().equals(ganador)){
                return true;
            }
        }
        for (int i = 0; i < boton.length; i++) {
            if(boton[0][i].getText().equals(ganador) && boton[1][i].getText().equals(ganador) && boton[2][i].getText().equals(ganador)){
                return true;
            }
        }
        if(boton[0][0].getText().equals(ganador) && boton[1][1].getText().equals(ganador) && boton[2][2].getText().equals(ganador)){
            return true;
        }
        if(boton[0][2].getText().equals(ganador) && boton[1][1].getText().equals(ganador) && boton[2][0].getText().equals(ganador)){
            return true;
        }
        return false;
    }
    public static boolean tableroLLeno(){
        for (int i = 0; i < boton.length; i++) {
            for (int j = 0; j < boton[i].length; j++) {
                if(boton[i][j].getText().equals("")){
                    return false;
                }
            }
        }
        return true;
    }
    ////////////////////////////////////////////////////////////////////
    private static void movimientoIA(){
        
        int[] ganador = detectarPosibleGanador(iconoJ2);
        if (0<=ganador[0]) {
            boton[ganador[0]][ganador[1]].setText(iconoJ2);
            System.out.println("puesta para ganar");
        }else{
            ganador = detectarPosibleGanador(iconoJ1);
            if (0<=ganador[0]) {
                boton[ganador[0]][ganador[1]].setText(iconoJ2);
                System.out.println("puesta para bloquear");
            }else{
                System.out.println("puesta aleatorio");
                // si no encuentra nada, se pone en un sitio aleatorio
                int x;
                int y;
                do {
                    x = (int)(Math.random() * boton.length);
                    y = (int)(Math.random() * boton[0].length);
                } while (!boton[x][y].getText().equals(""));
                boton[x][y].setText(iconoJ2);
            }
        }
    }
    private static int[] detectarPosibleGanador(String ganador){
        for (int i = 0; i < boton.length; i++) {
            if(boton[i][0].getText().equals("") && boton[i][1].getText().equals(ganador) && boton[i][2].getText().equals(ganador)){
                int[] dev = {i,0};
                return dev;
            }
            if(boton[i][0].getText().equals(ganador) && boton[i][1].getText().equals("") && boton[i][2].getText().equals(ganador)){
                int[] dev = {i,1};
                return dev;
            }
            if(boton[i][0].getText().equals(ganador) && boton[i][1].getText().equals(ganador) && boton[i][2].getText().equals("")){
                int[] dev = {i,2};
                return dev;
            }
        }
        for (int i = 0; i < boton.length; i++) {
            if(boton[0][i].getText().equals("") && boton[1][i].getText().equals(ganador) && boton[2][i].getText().equals(ganador)){
                int[] dev = {0,i};
                return dev;
            }
            if(boton[0][i].getText().equals(ganador) && boton[1][i].getText().equals("") && boton[2][i].getText().equals(ganador)){
                int[] dev = {1,i};
                return dev;
            }
            if(boton[0][i].getText().equals(ganador) && boton[1][i].getText().equals(ganador) && boton[2][i].getText().equals("")){
                int[] dev = {2,i};
                return dev;
            }
        }
        if(boton[0][0].getText().equals("") && boton[1][1].getText().equals(ganador) && boton[2][2].getText().equals(ganador)){
            int[] dev = {0,0};
            return dev;
        }
        if(boton[0][0].getText().equals(ganador) && boton[1][1].getText().equals("") && boton[2][2].getText().equals(ganador)){
            int[] dev = {1,1};
            return dev;
        }
        if(boton[0][0].getText().equals(ganador) && boton[1][1].getText().equals(ganador) && boton[2][2].getText().equals("")){
            int[] dev = {2,2};
            return dev;
        }
        ////////////////////////////////////////////////////
        if(boton[0][2].getText().equals("") && boton[1][1].getText().equals(ganador) && boton[2][0].getText().equals(ganador)){
            int[] dev = {0,2};
            return dev;
        }
        if(boton[0][2].getText().equals(ganador) && boton[1][1].getText().equals("") && boton[2][0].getText().equals(ganador)){
            int[] dev = {1,1};
            return dev;
        }
        if(boton[0][2].getText().equals(ganador) && boton[1][1].getText().equals(ganador) && boton[2][0].getText().equals("")){
            int[] dev = {2,0};
            return dev;
        }
        int[] dev = {-1};
        return dev;
    }
}
