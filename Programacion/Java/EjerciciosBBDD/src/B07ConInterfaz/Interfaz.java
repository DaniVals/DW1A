package B07ConInterfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import B07ConInterfaz.helpers.ContactoBBDD;

public class Interfaz {
    
    private static JPanel panel;

    // los que indican que es cada textarea
    private static JLabel labelNombre;
    private static JLabel labelApellido;
    private static JLabel labelId;
    private static JLabel labelTelefono;
    private static JLabel labelEmail;

    public static JLabel labelSelectedNombre;
    public static JLabel labelSelectedApellido;
    public static JLabel labelSelectedId;
    public static JLabel labelSelectedTelefono;
    public static JLabel labelSelectedEmail;

    
    public static JLabel labelError;
    
    public static JTextField textareaNombre;
    public static JTextField textareaApellido;
    public static JTextField textareaId;
    public static JTextField textareaTelefono;
    public static JTextField textareaEmail;
    
    public static JLabel labelSelectedData;
    public static JTextField textareaCurrentData;
    
    private static JButton buttonInsertDelete;
    private static JButton buttonUpdate;
    private static JButton buttonDelete;

    private static JButton buttonSelectToJSON;
    private static JButton buttonSelectAll;
    private static JButton buttonSelect;
    private static JButton buttonNext;
    private static JButton buttonPrev;
    private static JButton buttonFirst;
    private static JButton buttonLast;
    
    private static ContactoBBDD sql;

    private static void createPanel() {
        
        panel = new JPanel();
        sql = new ContactoBBDD();
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
        buttonInsertDelete.setBounds(Main.width-200-offset, yfraction*1, 200, (int)(yfraction*1.5));
        buttonInsertDelete.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                sql.insertarContacto();
            }
        });
        panel.add(buttonInsertDelete);

        buttonUpdate = new JButton("Update por id");
        buttonUpdate.setBounds(Main.width-200-offset, yfraction*3, 200, (int)(yfraction*1.5));
        buttonUpdate.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                sql.updatePorIdContacto();
            }
        });
        panel.add(buttonUpdate);

        buttonDelete = new JButton("Delete por id");
        buttonDelete.setBounds(Main.width-200-offset, yfraction*5, 200, (int)(yfraction*1.5));
        buttonDelete.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                sql.deletePorIdContacto();
            }
        });
        panel.add(buttonDelete);

        buttonSelect = new JButton("Select where");
        buttonSelect.setBounds(Main.width-200-offset, yfraction*7, 200, (int)(yfraction*1.5));
        buttonSelect.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                sql.selectContactosFiltrado();
            }
        });
        panel.add(buttonSelect);

        buttonSelectAll = new JButton("Select All");
        buttonSelectAll.setBounds(Main.width-200-offset, yfraction*9, 200, (int)(yfraction*1.5));
        buttonSelectAll.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                sql.selectContactosAll();
            }
        });
        panel.add(buttonSelectAll);

        buttonSelectToJSON = new JButton("To JSON");
        buttonSelectToJSON.setBounds(Main.width-200-offset, yfraction*11, 200, (int)(yfraction*1.5));
        buttonSelectToJSON.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                sql.crearJson();
            }
        });
        panel.add(buttonSelectToJSON);



        final int botonpequenoWidth = 50;
        buttonNext = new JButton(">");
        buttonNext.setBounds(Main.width-50-offset, yfraction*16, botonpequenoWidth, yfraction);
        buttonNext.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                sql.siguienteContacto();
            }
        });
        panel.add(buttonNext);

        buttonPrev = new JButton("<");
        buttonPrev.setBounds(50, yfraction*16, botonpequenoWidth, yfraction);
        buttonPrev.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                sql.anteriorContacto();
            }
        });
        panel.add(buttonPrev);

        buttonLast = new JButton(">>");
        buttonLast.setBounds(Main.width-55-botonpequenoWidth-offset, yfraction*16, botonpequenoWidth, yfraction);
        buttonLast.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                sql.ultimoContacto();
            }
        });
        panel.add(buttonLast);

        buttonFirst = new JButton("<<");
        buttonFirst.setBounds(botonpequenoWidth+55, yfraction*16, botonpequenoWidth, yfraction);
        buttonFirst.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                sql.primerContacto();
            }
        });
        panel.add(buttonFirst);

        /////////////////////////////////////////////////////////////////
        
        
        textareaCurrentData = new JTextField("0");
        textareaCurrentData.setBounds(400 , yfraction*16, 50, yfraction);
        textareaCurrentData.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                sql.irAContacto(0);
            }
        });
        panel.add(textareaCurrentData);

        labelSelectedData = new JLabel("/0");
        labelSelectedData.setBounds(450, yfraction*16, 100, yfraction);
        panel.add(labelSelectedData);
        
        /////////////////////////////////////////////////////////////////

        labelError = new JLabel("Consola");
        labelError.setBounds(50, yfraction*11, Main.width-300-offset, yfraction*4);
        labelError.setBackground(Color.gray);
        labelError.setOpaque(true);
        labelError.setVerticalAlignment(SwingConstants.NORTH);
        panel.add(labelError);


        sql.selectContactosFiltrado();
        
    }

    public static JPanel getPanel(){
        if (panel == null) {
            createPanel();
        }
        return panel;
    }

}
