package src.F10ListaNumerosData;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
Realizar un programa que cree un fichero llamado notas.txt con un número entero en
cada línea. Los datos se leerán por teclado.  
*/
public class A1Escribir {
    public static void main(String[] args) throws IOException{

        DataOutputStream out = null;
        Scanner teclado = new Scanner(System.in);
        try {

            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Programacion/Java/EjerciciosArchivos/src/F10ListaNumerosData/input.int")));

            System.out.println("dame numeros enteros para que los guarde en un archivo, para acabar escribe un numero negativo");
            int tx= teclado.nextInt();
            while (0<=tx) {
                out.writeInt(tx);
                tx= teclado.nextInt();
            }



        }catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        teclado.close();
    }
}
