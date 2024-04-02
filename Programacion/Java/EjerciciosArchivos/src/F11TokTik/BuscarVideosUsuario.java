package src.F11TokTik;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class BuscarVideosUsuario {
    public static void main(String[] args) throws IOException {
        
        DataInputStream in = null;
        try {
            in = new DataInputStream(new BufferedInputStream(
                new FileInputStream("Programacion/Java/EjerciciosArchivos/src/F11TokTik/baseDeDatos.int")));
            
            String nombre, usuario, buscado="Dani videosboy";
            int meGusta, comentarios, duracion;
            try {
                while (true) {
                    nombre = in.readUTF();
                    usuario = in.readUTF();
                    meGusta = in.readInt();
                    comentarios = in.readInt();
                    duracion = in.readInt();

                    if (usuario.equalsIgnoreCase(buscado)) {
                        System.out.println( 
                            "Video:"+
                            "\n\tnombre: "+ nombre +
                            "\n\tusuario: "+ usuario +
                            "\n\tmeGusta: "+ meGusta +
                            "\n\tcomentarios: "+comentarios +
                            "\n\tduracion: "+ duracion
                        );
                    }
                }
            } catch (EOFException e) {}
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
    }
}

