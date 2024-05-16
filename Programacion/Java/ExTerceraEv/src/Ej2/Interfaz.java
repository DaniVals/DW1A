package Ej2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Ej2.helpers.PaisBBDD;

public class Interfaz {
    
    private static JPanel panel;

    public static JLabel labelError;
    
    public static JTextField textareaNombre;
    public static JTextField textareaPoblacion;
    
    private static JButton buttonSelect;
    private static JButton buttonInsert;
    
    private static PaisBBDD sql;

    private static void createPanel() {
        
        panel = new JPanel();
        sql = new PaisBBDD();
        panel.setLayout(null);
        
        final int yfraction = Main.height/10;
        final int xfraction = Main.width/10;

        //////////////////////////////////////////////////////////////////////////////////////////////

        textareaNombre = new JTextField();
        textareaNombre.setBounds(xfraction, yfraction*1, xfraction * 4, yfraction);
        panel.add(textareaNombre);

        textareaPoblacion = new JTextField();
        textareaPoblacion.setBounds(xfraction, yfraction*3, xfraction * 4, yfraction);
        panel.add(textareaPoblacion);


        ////////////////////////////////////////////////////////////////
        
        buttonSelect = new JButton("Buscar");
        buttonSelect.setBounds(xfraction * 6, yfraction*1, xfraction*3, yfraction);
        buttonSelect.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                sql.mostrarPoblacionPorNombre();
            }
        });
        panel.add(buttonSelect);

        buttonInsert = new JButton("Guardar");
        buttonInsert.setBounds(xfraction * 6, yfraction*3, xfraction*3, yfraction);
        buttonInsert.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                sql.insertarNuevoPais();
            }
        });
        panel.add(buttonInsert);
        
        /////////////////////////////////////////////////////////////////

        labelError = new JLabel("Consola");
        labelError.setBounds(xfraction * 1, yfraction*5, xfraction*8, yfraction*3);
        labelError.setBackground(Color.gray);
        labelError.setOpaque(true);
        labelError.setVerticalAlignment(SwingConstants.NORTH);
        panel.add(labelError);

        sql.insertarArchivo();
    }

    public static JPanel getPanel(){
        if (panel == null) {
            createPanel();
        }
        return panel;
    }

}
