package src.I00Pruebas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventoMouse implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse presionado");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse soltado");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entrado");
        Main.MoverBotonRandom();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse salido");
    }
    
}
