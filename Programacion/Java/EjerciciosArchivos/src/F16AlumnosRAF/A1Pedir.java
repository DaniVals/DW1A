package src.F16AlumnosRAF;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

public class A1Pedir {
    public static void main(String[] args) throws IOException {
        
		File fichero = new File("Programacion/Java/EjerciciosArchivos/src/F16AlumnosRAF/baseDeDatos.alumno");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");

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

            final int tamanoMaxChars = 15;
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


            
            System.out.println("quieres guardar?");
            if (true) { //poner varaible de teclado pq hard pereza

                //calcular tamaño de cada alumno
                int tamano = tamañoEnBytesDeCadaAlumno(tamanoMaxChars);
                file.writeInt(tamano); //lo pongo separado en una variable pq da error ns pq, pero se podia meter directamente
                for (Alumno alumno : alumnado) {
                    file.writeInt(alumno.getNumExpediente());
                    file.writeChars(ajustarTextoAlMaximo(alumno.getNombre(), '#', tamanoMaxChars));
                    file.writeChars(ajustarTextoAlMaximo(alumno.getApellido(), '#', tamanoMaxChars));
                }
            }



        teclado.close();
        file.close();
    }
    static int tamañoEnBytesDeCadaAlumno(int tamanoMaxChars){
        return
        4+ //cuatro por el numero de expediente
        2*tamanoMaxChars+ //2 por cada byte del nombre
        2*tamanoMaxChars; //2 por cada byte del apellido
    }
    static String ajustarTextoAlMaximo(String texto,char caracterEnBlanco, int numeroMaximo){
        
        if (texto.length() < numeroMaximo) {
            for (int i = texto.length(); i < numeroMaximo; i++) {
                texto += caracterEnBlanco;
            }
            return texto;
        }
        if (numeroMaximo < texto.length()) {
            return texto.substring(0, numeroMaximo);
        }
        return texto;

    }
    static void imprimir(Alumno[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
