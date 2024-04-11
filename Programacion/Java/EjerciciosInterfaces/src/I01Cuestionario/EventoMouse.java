package src.I01Cuestionario;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventoMouse implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse click");
        Main.CambiarTextoConCuestionario();
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse salido");
    }
    
}
