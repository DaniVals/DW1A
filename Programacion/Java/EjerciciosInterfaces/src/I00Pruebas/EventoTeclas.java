package src.I00Pruebas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventoTeclas implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Tecla pulsada");
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Tecla presionada");
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Tecla soltada");
    }
    
}
