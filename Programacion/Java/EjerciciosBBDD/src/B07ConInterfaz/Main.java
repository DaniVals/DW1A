package B07ConInterfaz;

import java.sql.SQLException;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;


import Singleton.SingletonBBDD;

public class Main {
    private static CardLayout cardLayout;
    private static JPanel panelContainer;

    public static final int width=900;
    public static final int height=700;
    public static void main(String[] args) throws SQLException {
        SingletonBBDD.createConnectionAsRoot("jdbc:mysql://localhost:3306/agenda");
        
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Agenda BBDD");
        ventana.setResizable(false);
        ventana.setSize(width, height);


        // añadir menu
        ventana.setJMenuBar(MenuBarBase.getMenu());


        cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout);
        ventana.add(panelContainer);

        panelContainer.add(InterfazBase.getPanel(), "inicio");
        panelContainer.add(InterfazInsert.getPanel(), "insert");
        panelContainer.add(InterfazSelect.getPanel(), "select");

        ventana.setVisible(true);
    }
    
    ////////////////////////////////////////////////////////////////////////////////
    public static void mostrarMenuInicio(){
        cardLayout.show(panelContainer, "inicio");
    }
    public static void mostrarMenuInsert(){
        cardLayout.show(panelContainer, "insert");
    }
    public static void mostrarMenuSelect(){
        cardLayout.show(panelContainer, "select");
    }
}
