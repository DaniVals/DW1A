package B07ConInterfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Singleton.SingletonBBDD;

public class InterfazInsert {
    
    private static JPanel panel;

    private static JLabel labelNombre;
    private static JLabel labelApellido;
    private static JLabel labelId;
    private static JLabel labelTelefono;
    private static JLabel labelEmail;

    private static JLabel labelError;
    
    private static JTextField textareaNombre;
    private static JTextField textareaApellido;
    private static JTextField textareaId;
    private static JTextField textareaTelefono;
    private static JTextField textareaEmail;

    private static JButton buttonInsertDelete;

    private static void createPanel() {
        
        panel = new JPanel();
        panel.setLayout(null);
        
        final int yfraction = Main.height/20;

        labelNombre = new JLabel("Nombre");
        labelNombre.setBounds(50, yfraction*1, 100, yfraction);
        panel.add(labelNombre);
        labelApellido = new JLabel("Apellido");
        labelApellido.setBounds(50, yfraction*3, 100, yfraction);
        panel.add(labelApellido);
        labelId = new JLabel("Id");
        labelId.setBounds(50, yfraction*5, 100, yfraction);
        panel.add(labelId);
        labelTelefono = new JLabel("Telefono");
        labelTelefono.setBounds(50, yfraction*7, 100, yfraction);
        panel.add(labelTelefono);
        labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, yfraction*9, 100, yfraction);
        panel.add(labelEmail);

        //////////////////////////////////////////////////////////////////////////////////////////////

        textareaNombre = new JTextField();
        textareaNombre.setBounds(150, yfraction*1, 200, yfraction);
        textareaNombre.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                textareaApellido.requestFocus();
            }
        });
        panel.add(textareaNombre);

        textareaApellido = new JTextField();
        textareaApellido.setBounds(150, yfraction*3, 200, yfraction);
        textareaApellido.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                textareaId.requestFocus();
            }
        });
        panel.add(textareaApellido);

        textareaId = new JTextField();
        textareaId.setBounds(150, yfraction*5, 200, yfraction);
        textareaId.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                textareaTelefono.requestFocus();
            }
        });
        panel.add(textareaId);

        textareaTelefono = new JTextField();
        textareaTelefono.setBounds(150, yfraction*7, 200, yfraction);
        textareaTelefono.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                textareaEmail.requestFocus();
            }
        });
        panel.add(textareaTelefono);

        textareaEmail = new JTextField();
        textareaEmail.setBounds(150, yfraction*9, 200, yfraction);
        textareaEmail.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                // textareaNombre.requestFocus();
            }
        });
        panel.add(textareaEmail);

        ////////////////////////////////////////////////////////////////

        buttonInsertDelete = new JButton("Insertar y reiniciar");
        buttonInsertDelete.setBounds(500, yfraction*1, 200, yfraction*3);
        buttonInsertDelete.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                insertarYBorrarTextarea();
            }
        });
        panel.add(buttonInsertDelete);

        //////////////////////////////////////////////////////////////////

        labelError = new JLabel("Consola");
        labelError.setBounds(50, yfraction*11, Main.width-100-10, yfraction*4);
        labelError.setBackground(Color.gray);
        labelError.setOpaque(true);
        labelError.setVerticalAlignment(SwingConstants.NORTH);
        panel.add(labelError);
        
    }

    public static JPanel getPanel(){
        if (panel == null) {
            createPanel();
        }
        return panel;
    }


    private static boolean chekearDatos(){
        boolean devuelto = true;
        String mensajeError = "";
        if (textareaId.getText().length()<=0) {
            devuelto = false;
            mensajeError += "Introduzca una id \n";
        }
        if (textareaNombre.getText().length()<=0) {
            devuelto = false;
            mensajeError += "Introduzca un nombre \n";
        }
        if (textareaApellido.getText().length()<=0) {
            devuelto = false;
            mensajeError += "Introduzca un apellido \n";
        }
        if (textareaEmail.getText().length()<=0) {
            devuelto = false;
            mensajeError += "Introduzca un email \n";
        }
        if (textareaTelefono.getText().length()<=0) {
            devuelto = false;
            mensajeError += "Introduzca un telefono \n";
        }
        try {
            Integer.parseInt(textareaId.getText());
        } catch (NumberFormatException e) {
            mensajeError += "Id no valida (un numero) \n";
            devuelto = false;
        }
        try {
            Integer.parseInt(textareaTelefono.getText());
        } catch (NumberFormatException e) {
            mensajeError += "Telefono no valido (un numero) \n";
            devuelto = false;
        }
        
        
        try {
            ResultSet selected = SingletonBBDD.getConnection().createStatement().executeQuery("SELECT COUNT(*) FROM contacto WHERE id = "+Integer.parseInt(textareaId.getText()));
            selected.next();
            int contContactos = selected.getInt("COUNT(*)");

            if (0<contContactos) {
                mensajeError += "No puedes usar esa id, esta repetida \n";
                devuelto = false;
            }

        } catch (SQLException e) {
            mensajeError += "Error al comprobar si ya existe alguien con esa id \n";
            devuelto = false;
        }

        if (devuelto == false) {
            labelError.setText(mensajeError);
        }
        return devuelto;
    }

    private static void insertarYBorrarTextarea(){
        if (chekearDatos()) {
            
            String sql = 
                "INSERT INTO contacto(id, nombre, apellido, telefono, email) "+
                "VALUES ('"+Integer.parseInt(textareaId.getText())+
                "', '"+textareaNombre.getText()+
                "', '"+textareaApellido.getText()+
                "', '"+Integer.parseInt(textareaTelefono.getText())+
                "', '"+textareaEmail.getText()+
                "')"
            ;

            System.out.println(sql);
            try {
                SingletonBBDD.getConnection().createStatement().executeUpdate(sql);
                labelError.setText("Se ha realizado el insert");

                textareaApellido.setText("");
                textareaNombre.setText("");
                textareaId.setText("");
                textareaTelefono.setText("");
                textareaEmail.setText("");

            } catch (SQLException e) {
                labelError.setText("Error al hacer el insert");
                e.printStackTrace();
            }

        }
    }
}
