package src.F00DemoByte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class CopyBytes {
    public static void main(String[] args) throws IOException {
        System.out.println("user dir:"+System.getProperty("user.dir"));
        FileInputStream in = null;
        FileOutputStream out = null;
        //C:\Users\Dani\Documents\repositorios\DW1A\Programacion\Java\EjerciciosArchivos\src\F00DemoNacho
        try {
            
            in = new FileInputStream("Programacion/Java/EjerciciosArchivos/src/F00DemoNacho/xanadu.txt");
            out = new FileOutputStream("Programacion/Java/EjerciciosArchivos/src/F00DemoNacho/outagain.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
                System.out.print ((char)c);
            }
        }
        finally {

            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
