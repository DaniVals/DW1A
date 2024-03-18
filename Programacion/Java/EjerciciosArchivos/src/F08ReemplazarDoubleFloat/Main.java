package src.F08ReemplazarDoubleFloat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
A partir de un fichero con código fuente en Java, crear otro fichero que sea igual que 
el original pero cambiando las variables de tipo double por variables de tipo float. 
*/
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			out = new PrintWriter  (new FileWriter("Programacion/Java/EjerciciosArchivos/src/F08ReemplazarDoubleFloat/FicheroCambiado.java"));
            in = new BufferedReader(new FileReader("Programacion/Java/EjerciciosArchivos/src/F08ReemplazarDoubleFloat/Fichero.java"));
            
            String l,lineaNueva = null;
            int pos;
            
            while ((l=in.readLine())!=null) {
				
				pos = l.indexOf ("double");
				
				if (pos==-1) {
					out.println (l);
				}
				else {
					lineaNueva = l.substring (0,pos) + "float" + l.substring (pos+6);
					out.println (lineaNueva);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
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
