package src.I02Calculadora;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Calculadora {
    private JPanel panel;
    private JButton botonSumar;
    private JButton botonRestar;
    private JButton botonMultiplicar;
    private JButton botonDividir;

    public Calculadora() {
        this.panel = new JPanel();
        this.botonSumar = new JButton("+");
        this.botonRestar = new JButton("+");
        this.botonMultiplicar = new JButton("+");
        this.botonDividir = new JButton("+");
    }

    
}
