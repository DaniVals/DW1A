package B07ConInterfaz;

import java.awt.Color;
import java.awt.TextArea;
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

public class Interfaz {
    
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
    
    private static JLabel labelSelectedData;
    private static JTextField textareaCurrentData;
    private static int posCursor=0;
    
    private static JButton buttonInsertDelete;
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
        
        buttonInsertDelete = new JButton("Insertar y reiniciar");
        buttonInsertDelete.setBounds(Main.width-200-offset, yfraction*1, 200, yfraction*2);
        buttonInsertDelete.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                insertarYBorrarTextarea();
            }
        });
        panel.add(buttonInsertDelete);

        buttonSelect = new JButton("Select where");
        buttonSelect.setBounds(Main.width-200-offset, yfraction*4, 200, yfraction*2);
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
        
        
        textareaCurrentData = new JTextField("0");
        textareaCurrentData.setBounds(400 , yfraction*16, 50, yfraction);
        textareaCurrentData.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                moveTo(2);
            }
        });
        panel.add(textareaCurrentData);

        labelSelectedData = new JLabel("/0");
        labelSelectedData.setBounds(450, yfraction*16, 100, yfraction);
        panel.add(labelSelectedData);
        
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

    ////////////////////////////////////////////// GLOBAL //////////////////////////////////////////////
    
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
    
    ////////////////////////////////////////////// SELECT //////////////////////////////////////////////
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
                    posCursor=0;
                    
                    labelError.setText("Se ha realizado el select");
                    labelSelectedData.setText("/ "+contContactos);
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
                        posCursor++;
                        labelError.setText("Mostrando contacto");
                    }else{
                        labelError.setText("No hay un siguiente");
                        cursor.previous();
                        break;
                    }
                }
            } else {
                for (int i = cant; i < 0; i++) {
                    if (cursor.previous()) {
                        labelError.setText("Mostrando contacto...");
                        showCursorPosition();
                        posCursor--;
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
    private static void moveTo(int pos){
        System.out.println("maximo :"+Integer.parseInt(labelSelectedData.getText().substring(2)));
        if (cursor==null) {
            return;
        }
        if (pos<0) {
            return;
        }
        if (Integer.parseInt(labelSelectedData.getText().substring(2))<pos) {
            return;
        }
        try {
            if (posCursor<pos) {
                System.out.println("superior");
                for (int i = posCursor; i < pos; i++) {
                    System.out.println("a");
                    // cursor.next();
                }
            } else {
                System.out.println("inferior");
                System.out.println(posCursor+","+pos);
                for (int i = posCursor-pos; i < posCursor; i++) {
                    System.out.println("b");
                    // cursor.previous();
                }
            }
            cursor.next();
            cursor.previous();
        } catch (SQLException e) {
            labelError.setText("Error al mover el cursor");
            e.printStackTrace();
        }
    }
    
    ////////////////////////////////////////////// INSERT //////////////////////////////////////////////
    
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
