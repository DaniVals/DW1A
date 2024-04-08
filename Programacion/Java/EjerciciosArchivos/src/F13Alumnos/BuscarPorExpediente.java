package src.F13Alumnos;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import src.F16AlumnosRAF.Alumno;

/*

Pedir  por  teclado  un  número  de  expediente.  Buscar  ese  número  de  expediente  en  el 
fichero alumnos. Si está, mostrar por pantalla el nombre y los apellidos de ese alumno. 
Si no está, mostrar el mensaje “Alumno no encontrado”.

*/

public class BuscarPorExpediente {
    public static void main(String[] args) throws IOException {
        
        int buscado = 77;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream("Programacion/Java/EjerciciosArchivos/src/F13Alumnos/baseDeDatos.alumno")));

                
            try{
                Alumno assist2;
                Object assist;
                while (true) {
                    assist = in.readObject();
                    if (assist instanceof Alumno) {
                        assist2 = (Alumno) assist;
                        if (assist2.getNumExpediente() == buscado) {
                            System.out.println("Alumno con expediente numero "+buscado+" encontrado:\n"+assist2.toString());
                            break;
                        }
                    }
                }
            } catch (EOFException e) {
                System.out.println("Alumno no encontrado");
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
        