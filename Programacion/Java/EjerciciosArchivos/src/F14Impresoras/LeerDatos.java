package src.F14Impresoras;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerDatos {
    
    public static void main(String[] args) throws IOException {
        
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream("Programacion/Java/EjerciciosArchivos/src/F14Impresoras/baseDeDatos.impresoras")));

            try{
                Object leido;
                while (true) {
                    leido = in.readObject();
                    if (leido instanceof Impresora) {
                        System.out.println( leido.toString() );
                    }
                }
            } catch (EOFException e) {
            }
            catch (ClassNotFoundException e) {
                System.out.println("error en la clase:");
                e.printStackTrace();
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
