package src.F13Alumnos;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

/*

Pedir  los  datos  de  10  alumnos  por  teclado.  Los  datos  son:  número  de  expediente, 
nombre y apellidos.  Almacenar los datos en un array de objetos. Después de haberlos 
almacenado en el array, ordenar los alumnos por número de expediente y 
almacenarlos en otro array. A continuación, almacenar los objetos del array ordenado 
en un fichero llamado alumnos.

*/

public class EscribirAlumnos {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner teclado = new Scanner(

            "69\nDaniel\nVals\n"+
            "68\nManuel\nVals\n"+
            "19\nAlex\nVals\n"+
            "23\nAlex\nMayo\n"+
            "20\nRaul\nVals\n"+
            "80\nMarcos\nMartinez\n"+
            "77\nSamuel\nDe luque\n"+
            "99\nXin\nZao\n"+
            "80\nMarcos\nMartinez\n"+
            "50\nMedia\nMitad\n"+
            System.in
        );
 
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream("Programacion/Java/EjerciciosArchivos/src/F13Alumnos/baseDeDatos.alumno")));



            Alumno[] alumnado = new Alumno[10];
            for (int i = 0; i < 10; i++) {
                System.out.println("Alumno numero "+(i+1));

                System.out.println("Numero de expediente del alumno");
                System.out.println("Nombre del alumno");
                System.out.println("Apellido del alumno");
                alumnado[i] = new Alumno(Integer.parseInt(teclado.nextLine()), teclado.nextLine(), teclado.nextLine());
            }

            imprimir(alumnado);
            System.out.println("\n\n");
            Arrays.sort(alumnado, new OrdenarAlumno());
            imprimir(alumnado);


            
            
            for (int i = 0; i < 10; i++) {
                out.writeObject(alumnado[i]);
            }



        } finally {
            out.close();
        }
        teclado.close();
    }




    static void imprimir(Alumno[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}