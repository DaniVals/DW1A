package src.F14Impresoras;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*

6.
A partir del fichero impresoras anterior crea un fichero ordenado por número de serie. 

*/

public class OrdenarGuardar {
    public static void main(String[] args) throws IOException {
        
        ObjectInputStream in = null;
        ObjectOutputStream outSorted = null;
        ArrayList<Impresora> imp = new ArrayList<Impresora>();
        try {
            in = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream("Programacion/Java/EjerciciosArchivos/src/F14Impresoras/baseDeDatos.impresoras")));
            
            outSorted = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream("Programacion/Java/EjerciciosArchivos/src/F14Impresoras/baseSort.impresoras")));
                
            try{
                Object leido;
                while (true) {
                    leido = in.readObject();
                    if (leido instanceof Impresora) {
                        
                        imp.add(((Impresora)leido));
                    }
                }
            } catch (EOFException e) {
                imp.sort(new OrdenarImpresora());
                for (Impresora impresora : imp) {
                    outSorted.writeObject(impresora);
                }
            }
            catch (ClassNotFoundException e) {
                System.out.println("error en la clase:");
                e.printStackTrace();
            }
        } finally {
            in.close();
            outSorted.close();
        }




    }
}
