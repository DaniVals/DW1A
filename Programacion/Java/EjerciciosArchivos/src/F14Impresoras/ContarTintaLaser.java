package src.F14Impresoras;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/*
4.
A  partir  del  fichero  impresoras  anterior  contabiliza  cuántas  impresoras  son  de  tinta  y 
cuántas son láser. Muestra estos dos valores por pantalla. 

*/
public class ContarTintaLaser {
    public static void main(String[] args) throws IOException {
        
        int nLaser = 0, nTinta = 0;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream("Programacion/Java/EjerciciosArchivos/src/F14Impresoras/baseDeDatos.impresoras")));

                
            try{
                Object leido;
                while (true) {
                    leido = in.readObject();
                    if (leido instanceof Impresora) {
                        
                        switch(((Impresora)leido).getTipo()){
                            case TINTA:
                                nTinta++;
                            break;
                            case LASER:
                                nLaser++;
                            break;
                        }
                    }
                }
            } catch (EOFException e) {
                System.out.println("Impresoras por laser "+nLaser);
                System.out.println("Impresoras por tinta "+nTinta);
            }
            catch (ClassNotFoundException e) {
                System.out.println("error en la clase:");
                e.printStackTrace();
            }
        } finally {
            in.close();
        }
    }
}
