package src.F14Impresoras;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/*
5.
A partir del fichero impresoras anterior crea dos ficheros: uno con las impresoras láser 
y otro con las impresoras de tinta. 


6.
A partir del fichero impresoras anterior crea un fichero ordenado por número de serie. 

*/

public class SepararTintaLaser {
    public static void main(String[] args) throws IOException {
        
        ObjectInputStream in = null;
        ObjectOutputStream outTinta = null;
        ObjectOutputStream outLaser = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream("Programacion/Java/EjerciciosArchivos/src/F14Impresoras/baseDeDatos.impresoras")));
                
            outTinta = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream("Programacion/Java/EjerciciosArchivos/src/F14Impresoras/baseDeTinta.impresoras")));
            outLaser = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream("Programacion/Java/EjerciciosArchivos/src/F14Impresoras/baseDeLaser.impresoras")));

            try{
                Object leido;
                while (true) {
                    leido = in.readObject();
                    if (leido instanceof Impresora) {
                        
                        switch(((Impresora)leido).getTipo()){
                            case TINTA:
                                outTinta.writeObject(leido);
                            break;
                            case LASER:
                                outLaser.writeObject(leido);
                            break;
                        }
                    }
                }
            } catch (EOFException e) {
                System.out.println("Archivos creados con exito");
            }
            catch (ClassNotFoundException e) {
                System.out.println("error en la clase:");
                e.printStackTrace();
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (outTinta != null) {
                outTinta.close();
            }
            if (outLaser != null) {
                outLaser.close();
            }
        }
    }
}
