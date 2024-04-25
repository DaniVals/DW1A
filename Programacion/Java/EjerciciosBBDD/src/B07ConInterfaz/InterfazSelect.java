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

public class InterfazSelect {
    
    private static JPanel panel;

    private static JLabel labelNombre;
    private static JLabel labelApellido;
    private static JLabel labelId;
    private static JLabel labelTelefono;
    private static JLabel labelEmail;

    private static JLabel labelSelectedNombre;
    private static JLabel labelSelectedApellido;
    private static JLabel labelSelectedId;
    private static JLabel labelSelectedTelefono;
    private static JLabel labelSelectedEmail;

    private static JLabel labelError;
    
    private static JTextField textareaNombre;
    private static JTextField textareaApellido;
    private static JTextField textareaId;
    private static JTextField textareaTelefono;
    private static JTextField textareaEmail;

    private static JButton buttonSelect;
    private static JButton buttonNext;
    private static JButton buttonPrev;

    private static ResultSet cursor;

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

        labelSelectedNombre = new JLabel("Nombre:");
        labelSelectedNombre.setBounds(400, yfraction*1, 200, yfraction);
        panel.add(labelSelectedNombre);
        labelSelectedApellido = new JLabel("Apellido:");
        labelSelectedApellido.setBounds(400, yfraction*3, 200, yfraction);
        panel.add(labelSelectedApellido);
        labelSelectedId = new JLabel("Id:");
        labelSelectedId.setBounds(400, yfraction*5, 200, yfraction);
        panel.add(labelSelectedId);
        labelSelectedTelefono = new JLabel("Telefono:");
        labelSelectedTelefono.setBounds(400, yfraction*7, 200, yfraction);
        panel.add(labelSelectedTelefono);
        labelSelectedEmail = new JLabel("Email:");
        labelSelectedEmail.setBounds(400, yfraction*9, 200, yfraction);
        panel.add(labelSelectedEmail);

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

        final int offset = 60;

        buttonSelect = new JButton("Aplicar filtros");
        buttonSelect.setBounds(Main.width-200-offset, yfraction*1, 200, yfraction*3);
        buttonSelect.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                seleccionarDatos();
            }
        });
        panel.add(buttonSelect);

        buttonNext = new JButton(">");
        buttonNext.setBounds(Main.width-100-offset, yfraction*16, 100, yfraction);
        buttonNext.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                moveCursor(1);
            }
        });
        panel.add(buttonNext);

        buttonPrev = new JButton("<");
        buttonPrev.setBounds(50, yfraction*16, 100, yfraction);
        buttonPrev.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                moveCursor(-1);
            }
        });
        panel.add(buttonPrev);

        /////////////////////////////////////////////////////////////////

        labelError = new JLabel("Consola");
        labelError.setBounds(50, yfraction*11, Main.width-50-offset, yfraction*4);
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
        if (0<textareaId.getText().length()) {
            try {
                Integer.parseInt(textareaId.getText());
            } catch (NumberFormatException e) {
                mensajeError += "Id no valida (un numero) \n";
                devuelto = false;
            }
        }
        if (0<textareaTelefono.getText().length()) {
            try {
                Integer.parseInt(textareaTelefono.getText());
            } catch (NumberFormatException e) {
                mensajeError += "Telefono no valido (un numero) \n";
                devuelto = false;
            }
        }
        if (!devuelto) {
            labelError.setText(mensajeError);
        }
        labelError.setText(mensajeError);
        return devuelto;
    }

    private static String crearWhere(){
        String devuelto="";
        if (0<textareaId.getText().length()) {
            if (devuelto.length()<=0) {
                devuelto += "id = "+textareaId.getText();
            }else{
                devuelto += " AND id = "+textareaId.getText();
            }
        }
        if (0<textareaNombre.getText().length()) {
            if (devuelto.length()<=0) {
                devuelto += "nombre LIKE '"+textareaNombre.getText()+"%'";
            }else{
                devuelto += " AND nombre LIKE '"+textareaNombre.getText()+"%'";
            }
        }
        if (0<textareaApellido.getText().length()) {
            if (devuelto.length()<=0) {
                devuelto += "apellido LIKE '"+textareaApellido.getText()+"%'";
            }else{
                devuelto += " AND apellido LIKE '"+textareaApellido.getText()+"%'";
            }
        }
        if (0<textareaTelefono.getText().length()) {
            if (devuelto.length()<=0) {
                devuelto += "telefono LIKE '"+textareaTelefono.getText()+"%'";
            }else{
                devuelto += " AND telefono LIKE '"+textareaTelefono.getText()+"%'";
            }
        }
        if (0<textareaEmail.getText().length()) {
            if (devuelto.length()<=0) {
                devuelto += "email LIKE '"+textareaEmail.getText()+"%'";
            }else{
                devuelto += " AND email LIKE '"+textareaEmail.getText()+"%'";
            }
        }
        return devuelto;
    }
    private static void seleccionarDatos(){
        if (chekearDatos()) {
            
            String sql = "FROM contacto";

            // si puso un filtro
            if (
                0<textareaId.getText().length() 
                || 0<textareaNombre.getText().length()
                || 0<textareaApellido.getText().length()
                || 0<textareaTelefono.getText().length()
                || 0<textareaEmail.getText().length()
            ) {
                sql+=" WHERE "+crearWhere();
            }

            System.out.println(sql);
            try {
                ResultSet selected = SingletonBBDD.getConnection().createStatement().executeQuery("SELECT COUNT(*) "+sql);
                selected.next();
                int contContactos = selected.getInt("COUNT(*)");

                if (contContactos <= 0) {
                    labelError.setText("No se han encontrado datos");
                }else{
                    cursor = SingletonBBDD.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * "+sql);
                    cursor.next();
                    showCursorPosition();
                    
                    labelError.setText("Se ha realizado el select " + contContactos);
                }
            } catch (SQLException e) {
                labelError.setText("Error al hacer el select");
                e.printStackTrace();
            }

        }
    }

    private static void showCursorPosition() throws SQLException{
        if (cursor != null) {
            labelSelectedNombre.setText("N: "+cursor.getString("nombre"));
            labelSelectedApellido.setText("A: "+cursor.getString("apellido"));
            labelSelectedId.setText("I: "+cursor.getInt("id"));
            labelSelectedTelefono.setText("T: "+cursor.getInt("telefono"));
            labelSelectedEmail.setText("E: "+cursor.getString("email"));
        }
    }

    private static void moveCursor(int cant){
        if (cursor==null) {
            return;
        }
        if (cant==0) {
            return;
        }
        try {
            if (0<cant) {
                for (int i = 0; i < cant; i++) {
                    if (cursor.next()) {
                        labelError.setText("Mostrando contacto...");
                        showCursorPosition();
                        labelError.setText("Mostrando contacto");
                    }else{
                        labelError.setText("No hay un siguiente");
                        break;
                    }
                }
            } else {
                for (int i = cant; i < 0; i++) {
                    if (cursor.previous()) {
                        labelError.setText("Mostrando contacto...");
                        showCursorPosition();
                        labelError.setText("Mostrando contacto");
                    }else{
                        labelError.setText("No hay un anterior");
                        cursor.next();
                        break;
                    }
                }
                
            }
        } catch (SQLException e) {
            labelError.setText("Error al mover el cursor");
            e.printStackTrace();
        }
    }

    // programacion 30 mins
    // interfaz 1 horas
}
