package src.F16AlumnosRAF;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class A2BuscarReemplazar {
    public static void main(String[] args) throws IOException {
        
		File fichero = new File("Programacion/Java/EjerciciosArchivos/src/F16AlumnosRAF/baseDeDatos.alumno");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        int numBytesPorAlumno = file.readInt(); //lee el primer int que es el numero de bytes que ocupa cada alumno, para el seek
        final int ALUMNO_BUSCADO = 10;

        file.seek(4 + numBytesPorAlumno * (ALUMNO_BUSCADO -1));
        System.out.println("exp:      "+file.readInt());
        System.out.println("nombre:   "+getString(file, '#', 15));
        System.out.println("apellido: "+getString(file, '#', 15));


        file.close();
    }
    private static String getString(RandomAccessFile file, char endChar, int tamanoTexto) throws IOException {
        String devolver="";
        char nextchar;
        for (int i = 0; i < tamanoTexto; i++) {
            nextchar=file.readChar();
            if (nextchar != endChar) {
                devolver += nextchar;
            }else{
                file.seek(file.getFilePointer() + ((tamanoTexto - i - 1)*2));
                return devolver;
            }
        }
        return devolver;
    }
}
