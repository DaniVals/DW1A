package src.I02Calculadora;

import javax.swing.JFrame;

public class Main {
    // una calculadora (dos inputs de texto y cuatro botones) ademas que avise de que no se introduzca ambos valores "debe rellenar ambos campos"

    public static JFrame ventana;
    public static void main(String[] args) {
        //crear la ventana
        ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Calculadora");
        ventana.setResizable(false);
        ventana.setSize(700, 500);



        ventana.add(new Calculadora().getPanel());

        ventana.setVisible(true);
    }
}
