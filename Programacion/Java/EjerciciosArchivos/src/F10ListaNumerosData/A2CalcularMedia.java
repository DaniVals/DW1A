package src.F10ListaNumerosData;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Realizar  otro  programa  que  leyendo  el  fichero  anterior  cree  un  nuevo  archivo  en  el 
que  se  almacenen  los  números  cuyo  valor  sea  mayor  que  la  media.  Además,  se  deberá 
mostrar por pantalla la suma total de los números y la media.
*/
public class A2CalcularMedia {
    public static void main(String[] args) throws IOException {
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream("Programacion/Java/EjerciciosArchivos/src/F10ListaNumerosData/input.int")));
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Programacion/Java/EjerciciosArchivos/src/F10ListaNumerosData/output.int")));
            
            int n, suma = 0,cont=0;
            
            try {
                while (true) {
                    n = in.readInt();
                    suma+=n;
                    cont++;
                }
            } catch (EOFException e) {}

            int media = (suma/cont);
            
            //reiniciar
            in.close();
            in = new DataInputStream(new BufferedInputStream(new FileInputStream("Programacion/Java/EjerciciosArchivos/src/F10ListaNumerosData/input.int")));

            
            try {
                while (true) {
                    n = in.readInt();
                    if (media<n) {
                        out.writeInt(n);
                        System.out.println(n);
                    }
                }
            } catch (EOFException e) {}
            
            System.out.println("suma:  "+suma);
            System.out.println("media: "+media);

        }
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
