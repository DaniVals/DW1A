package src.I02Calculadora;

import javax.swing.JFrame;

public class Main {
    public static JFrame ventana;
    public static void main(String[] args) {
        //crear la ventana
        ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Pruebas");
        ventana.setResizable(false);
        ventana.setSize(700, 500);
    }
}
