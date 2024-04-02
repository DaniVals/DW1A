package src.F07CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
A partir de un fichero en formato csv, crear otro fichero csv que tenga en cada línea el 
primer y el último valor de la línea correspondiente del fichero csv original.
*/
public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new FileReader("Programacion/Java/EjerciciosArchivos/src/F07CSV/input.csv"));
            out = new PrintWriter(  new FileWriter("Programacion/Java/EjerciciosArchivos/src/F07CSV/output.csv"));
            
            String l, separador=",";



            while ((l = in.readLine()) != null) {
                String[] array = l.split(separador);
                out.println(array[0]+","+array[array.length-1]);
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

