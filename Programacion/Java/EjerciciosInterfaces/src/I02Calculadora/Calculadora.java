package src.I02Calculadora;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora {
    private JPanel panel;
    private JButton botonSumar;
    private JButton botonRestar;
    private JButton botonMultiplicar;
    private JButton botonDividir;
    
    public JTextField numero1;
    public JTextField numero2;
    public JLabel resultado;

    public Calculadora() {
        this.panel = new JPanel();
        panel.setLayout(null);

        this.botonSumar = new JButton("+");
        this.botonRestar = new JButton("-");
        this.botonMultiplicar = new JButton("*");
        this.botonDividir = new JButton("/");

        this.numero1 = new JTextField();
        this.numero2 = new JTextField();
        this.resultado = new JLabel("Resultado:");
        resultado.setFont(new Font("Arial", Font.PLAIN, 24));

        colocarBotones(50,300);
        colocarInputsYTexto(50,50);

        botonSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSuma();
            }
        });
        botonRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResta();
            }
        });
        botonMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMultiplicacion();
            }
        });
        botonDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularDivision();
            }
        });

        panel.add(botonSumar);
        panel.add(botonRestar);
        panel.add(botonMultiplicar);
        panel.add(botonDividir);

        panel.add(numero1);
        panel.add(numero2);
        panel.add(resultado);
    }

    public JPanel getPanel(){
        return panel;
    }

    public void colocarBotones(int x, int y){
        botonSumar.setBounds(x, y, 100, 50);
        botonRestar.setBounds(x+100, y, 100, 50);
        botonMultiplicar.setBounds(x, y+50, 100, 50);
        botonDividir.setBounds(x+100, y+50, 100, 50);
    }
    public void colocarInputsYTexto(int x, int y){
        numero1.setBounds  (x, y, 500, 25);
        numero2.setBounds  (x, y+25, 500, 25);
        resultado.setBounds(x, y+100, 500, 25);
    }


    public void mensajeError(){
        resultado.setForeground(Color.RED);
        resultado.setText("Numeros no validos");
    }
    public void mensajeResultado(double resultado){
        this.resultado.setForeground(Color.GREEN);
        this.resultado.setText("Resultado: "+resultado);
    }
    public void calcularSuma(){
        double numeros[] = getNums();
        if (numeros == null) {
            mensajeError();
            return;
        }
        mensajeResultado(numeros[0]+numeros[1]);
    }
    public void calcularResta(){
        double numeros[] = getNums();
        if (numeros == null) {
            mensajeError();
            return;
        }
        mensajeResultado(numeros[0]-numeros[1]);
    }
    public void calcularMultiplicacion(){
        double numeros[] = getNums();
        if (numeros == null) {
            mensajeError();
            return;
        }
        mensajeResultado(numeros[0]*numeros[1]);
    }
    public void calcularDivision(){
        double numeros[] = getNums();
        if (numeros == null) {
            mensajeError();
            return;
        }
        if (numeros[0] == 0 && numeros[1] == 0) {
            mensajeError();
            return;
        }
        mensajeResultado(numeros[0]/numeros[1]);
    }
    public double[] getNums(){
        double[] n={0,0};
        try {
            n[0] = Double.parseDouble(numero1.getText());
            n[1] = Double.parseDouble(numero2.getText());
        } catch (NumberFormatException e) {
            return null;
        }
        return n;
    }
}
