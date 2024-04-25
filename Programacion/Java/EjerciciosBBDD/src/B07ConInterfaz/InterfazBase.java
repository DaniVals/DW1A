package B07ConInterfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfazBase {
    
    private static JPanel panel;

    private static JButton insertMenuButton;
    private static JButton updateMenuButton;
    private static JButton deleteMenuButton;
    private static JButton selectMenuButton;
    private static JLabel titulo;

    private static void createPanel() {
        panel = new JPanel();
        panel.setLayout(null);

        final int buttonHeight = 50;

        final int incrementoX = Main.width/6;
        int i = incrementoX, j = Main.height/5 * 3;

        titulo = new JLabel("Contactos");
        final int textY = 24;
        titulo.setBounds(incrementoX, j-textY, 999, textY);
        titulo.setFont(new Font("Arial", Font.PLAIN, textY));
        panel.add(titulo);

        insertMenuButton = new JButton("Insertar contacto");
        insertMenuButton.setBounds(i, j, incrementoX, buttonHeight);
        insertMenuButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                Main.mostrarMenuInsert();
            }
        });
        panel.add(insertMenuButton);

        i += incrementoX;
        updateMenuButton = new JButton("Update contacto");
        updateMenuButton.setBounds(i, j, incrementoX, buttonHeight);
        updateMenuButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                // Main.mostrarMenuInsert();
            }
        });
        panel.add(updateMenuButton);
        
        i += incrementoX;
        deleteMenuButton = new JButton("Delete contacto");
        deleteMenuButton.setBounds(i, j, incrementoX, buttonHeight);
        deleteMenuButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                // Main.mostrarMenuInsert();
            }
        });
        panel.add(deleteMenuButton);

        i += incrementoX;
        selectMenuButton = new JButton("Select contacto");
        selectMenuButton.setBounds(i, j, incrementoX, buttonHeight);
        selectMenuButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                Main.mostrarMenuSelect();
            }
        });
        panel.add(selectMenuButton);

    }

    public static JPanel getPanel(){
        if (panel == null) {
            createPanel();
        }
        return panel;
    }
}
