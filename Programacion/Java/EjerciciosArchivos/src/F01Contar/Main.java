package src.F01Contar;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    /*
     * contar 'a'
     * contar 'a' por linea
     * 
     */
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        try {
            in = new FileInputStream("Programacion/Java/EjerciciosArchivos/src/F01Contar/input.txt");
            
            System.out.println(in.getChannel().size());
            System.out.println(in.getChannel().position());

            System.out.println("Numero de lineas: "+Buscador.ContarLineas(in));

            in.getChannel().position(0);
            System.out.println("Numero de a: "+Buscador.ContarAll('a', in));
            
            in.getChannel().position(0);
            System.out.println("Numero de a por linea: "+Buscador.ContarLinea('a', in));
            
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
