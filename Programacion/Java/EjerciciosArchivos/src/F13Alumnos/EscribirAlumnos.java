package src.F13Alumnos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Scanner;

public class EscribirAlumnos {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner teclado = new Scanner(

            "video1\ntu mami 69\n5\n3\n4\n"+
            System.in
        );
 
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream("Programacion/Java/EjerciciosArchivos/src/F12GuardarObjetos/baseDeDatos.int")));

            for (int i = 0; i < 40; i++) {
                System.out.println("Alumno numero "+(i+1));

                System.out.println("Nombre del video");

                out.writeObject();
            }
        } finally {
            out.close();
        }
    }
}