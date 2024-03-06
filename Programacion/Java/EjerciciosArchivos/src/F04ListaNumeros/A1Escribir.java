package src.F04ListaNumeros;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
Realizar un programa que cree un fichero llamado notas.txt con un número entero en
cada línea. Los datos se leerán por teclado.  
*/
public class A1Escribir {
    public static void main(String[] args) {

        PrintWriter out = null;
        Scanner teclado = new Scanner(System.in);
        try {

            out = new PrintWriter(new FileWriter("Programacion/Java/EjerciciosArchivos/src/F04ListaNumeros/notas.txt"));

            System.out.println("dame numeros enteros para que los guarde en un archivo, para acabar escribe un numero negativo");
            int tx= pedirNum(teclado);
            while (0<=tx) {
                out.write(tx+"\n");
                tx= pedirNum(teclado);
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


/*

DEBERES

usando el metodo has next int

*/



    public static int pedirNum(Scanner teclado){
        System.out.println("nuevo valor:");
        String tx= teclado.nextLine();
        if (isNum(tx)) {
            return Integer.parseInt(tx);
        }
        while (!isNum(tx)) {
            System.out.println("no valido, repita");
            tx= teclado.nextLine();
        }
        return Integer.parseInt(tx);
    }
    public static boolean isNum(String tx){
        try {
            Integer.parseInt(tx);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
