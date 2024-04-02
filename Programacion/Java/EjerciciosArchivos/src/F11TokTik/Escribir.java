package src.F11TokTik;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Escribir {
    public static void main(String[] args) throws IOException{

        DataOutputStream out = null;
        Scanner teclado = new Scanner(

            "video1\ntu mami 69\n5\n3\n4\n"+
            "video2\ntu mami 69\n4\n3\n3\n"+
            "video3\ntu mami 69\n6\n3\n2\n"+
            "video4\ntu mami 69\n7\n7\n7\n"+
            "gameplay de MC\ntu mami 69\n50\n34\n10\n"+
            "Primer video!!!!\nfanatico jarro\n2\n3\n4\n"+
            "Desafio plantas contra zombies\nfanatico jarro\n5\n3\n4\n"+
            "carreritas gtaV\nDanirep\n5\n3\n4\n"+
            "Recortables plantas contra zombies\nDani videosboy\n41\n10\n7\n"+
            "Empezando la aventura\nDani videosboy\n11\n5\n15\n"+
            System.in
        );

        try {

            out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("Programacion/Java/EjerciciosArchivos/src/F11TokTik/baseDeDatos.int")));

            for (int i=0; i<10; i++) {
                System.out.println("\nComentario numero "+(i+1));

                System.out.println("Nombre del video");
                out.writeUTF(teclado.nextLine());

                System.out.println("Nombre del usuario");
                out.writeUTF(teclado.nextLine());
                
                System.out.println("numero me gusta");
                out.writeInt(Integer.parseInt(teclado.nextLine()));

                System.out.println("numero de comentarios");
                out.writeInt(Integer.parseInt(teclado.nextLine()));
                
                System.out.println("duracion");
                out.writeInt(Integer.parseInt(teclado.nextLine()));
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
