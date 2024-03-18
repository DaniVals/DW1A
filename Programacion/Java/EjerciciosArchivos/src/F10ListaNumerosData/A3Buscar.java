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
Usando  el  fichero  notas.txt  como  fuente  de  datos,  desarrollar  un  programa  que  pida 
por  teclado  un  número  y  lo  busque  en  el  fichero.  Si  lo  encuentra,  mostrará  el  valor 
anterior  (si  lo  hubiese)  y  el    siguiente  (si  lo  hubiese).  En  caso  contrario,  mostrar  el 
mensaje “número no encontrado”.
*/

public class A3Buscar {
    public static void main(String[] args) throws IOException {
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream("Programacion/Java/EjerciciosArchivos/src/F10ListaNumerosData/input.int")));
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Programacion/Java/EjerciciosArchivos/src/F10ListaNumerosData/output.int")));
            
            int buscado = 7; //cambiar aqui el buscado

            int n;

            int anterior= -1;
            int actual= -1;
            int siguiente= -1;

            //buscar el actual (y guardar el anterior para cuando se encuentr)
            try {
                while (true) {
                    n = in.readInt();
                    //detectar si se ha encontrado
                    if (n==buscado) {

                        //si se encuentra, sacar ese numero y el siguiente y salir del bucle
                        actual=n;
                        siguiente = in.readInt();
                        break;
                    } else {

                        //si no se encuentra, guardar ese dato por si es el posible dato anterior
                        anterior=n;
                    }
                }
            } catch (EOFException e) {}

            
            //imprimir
            if (actual== -1) {
                System.out.println("numero no encontrado");
            }else{
                
                //imprimir anterior
                if (anterior== -1) {
                    System.out.println("no tiene un numero anterior");
                }else{
                    System.out.println("anterior:  "+anterior);
                }
                
                //imprimir actual ya que ya se comprobo antes q existia
                System.out.println("actual:    "+actual);


                //imprimir siguiente
                if (siguiente== -1) {
                    System.out.println("no tiene un numero siguiente");
                }else{
                    System.out.println("siguiente: "+siguiente);
                }
            }

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

