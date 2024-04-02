package src.F11TokTik;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class BuscarMenosLikes {
    public static void main(String[] args) throws IOException {
        
        DataInputStream in = null;
        try {
            in = new DataInputStream(new BufferedInputStream(
                new FileInputStream("Programacion/Java/EjerciciosArchivos/src/F11TokTik/baseDeDatos.int")));
            
            String nombre, usuario;
            int meGusta, comentarios, duracion;
            String nombreMenosLikes=null, usuarioMenosLikes=null;
            int meGustaMenosLikes=0, comentariosMenosLikes=0, duracionMenosLikes=0;
            try {
                nombreMenosLikes = in.readUTF();
                usuarioMenosLikes = in.readUTF();
                meGustaMenosLikes = in.readInt();
                comentariosMenosLikes = in.readInt();
                duracionMenosLikes = in.readInt();
                while (true) {
                    nombre = in.readUTF();
                    usuario = in.readUTF();
                    meGusta = in.readInt();
                    comentarios = in.readInt();
                    duracion = in.readInt();

                    if (meGusta<meGustaMenosLikes) {
                        nombreMenosLikes = nombre;
                        usuarioMenosLikes = usuario;
                        meGustaMenosLikes = meGusta;
                        comentariosMenosLikes = comentarios;
                        duracionMenosLikes = duracion;
                    }
                }
            } catch (EOFException e) {}

            if (nombreMenosLikes!=null) {
                System.out.println( 
                    "Video:"+
                    "\n\tnombre: "+ nombreMenosLikes +
                    "\n\tusuario: "+ usuarioMenosLikes +
                    "\n\tmeGusta: "+ meGustaMenosLikes +
                    "\n\tcomentarios: "+comentariosMenosLikes +
                    "\n\tduracion: "+ duracionMenosLikes
                );
            }else{
                System.out.println("no se han encontrado videos");
            }
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
