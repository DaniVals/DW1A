package src.F04ListaNumeros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
Usando  el  fichero  notas.txt  como  fuente  de  datos,  desarrollar  un  programa  que  pida 
por  teclado  un  número  y  lo  busque  en  el  fichero.  Si  lo  encuentra,  mostrará  el  valor 
anterior  (si  lo  hubiese)  y  el    siguiente  (si  lo  hubiese).  En  caso  contrario,  mostrar  el 
mensaje “número no encontrado”.
*/
public class A3Buscar {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new FileReader("Programacion/Java/EjerciciosArchivos/src/F04ListaNumeros/notas.txt"));
            out = new PrintWriter(new FileWriter("Programacion/Java/EjerciciosArchivos/src/F04ListaNumeros/notas2.txt"));
            
            int buscado = 4;

            String l;
            int n;

            int anterior= -1;
            int actual= -1;
            int siguiente= -1;


            while ((l = in.readLine()) != null) {
                n=Integer.parseInt(l);
                if (n==buscado) {
                    actual=n;
                    break;
                } else {
                    anterior=n;
                }
            }
            l = in.readLine();
            if (l!= null) {
                siguiente=Integer.parseInt(l);
            }
            
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

