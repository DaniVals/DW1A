package B07ConInterfaz;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuBarBase {
    
    private static JMenuBar barraMenu;

    private static void createMenu() {
        barraMenu = new JMenuBar();

        JMenu menuContactos = new JMenu("Contactos");
            JMenuItem insert = new JMenuItem("Insert");
            insert.addActionListener(new ActionListener() {
                @Override public void actionPerformed(ActionEvent e) {
                    Main.mostrarMenuInsert();
                }
            });
            menuContactos.add(insert);
            JMenuItem update = new JMenuItem("Update");
            update.addActionListener(new ActionListener() {
                @Override public void actionPerformed(ActionEvent e) {
                }
            });
            menuContactos.add(update);
            JMenuItem delete = new JMenuItem("Delete");
            delete.addActionListener(new ActionListener() {
                @Override public void actionPerformed(ActionEvent e) {
                }
            });
            menuContactos.add(delete);

            JMenuItem select = new JMenuItem("Select");
            select.addActionListener(new ActionListener() {
                @Override public void actionPerformed(ActionEvent e) {
                    Main.mostrarMenuSelect();
                }
            });
            menuContactos.add(select);

            menuContactos.addSeparator();//////////////////////////////////////////////

            JMenuItem inicio = new JMenuItem("Inicio");
            inicio.addActionListener(new ActionListener() {
                @Override public void actionPerformed(ActionEvent e) {
                    Main.mostrarMenuInicio();
                }
            });
            menuContactos.add(inicio);

        barraMenu.add(menuContactos);
    }

    public static JMenuBar getMenu(){
        if (barraMenu == null) {
            createMenu();
        }
        return barraMenu;
    }
}
