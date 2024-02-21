package src.F02DemoLine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class CopyLine {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new FileReader("Programacion/Java/EjerciciosArchivos/src/F02DemoLine/input.txt"));
            out = new PrintWriter(new FileWriter("Programacion/Java/EjerciciosArchivos/src/F02DemoLine/output.txt"));

            String l;
            ArrayList<String> array = new ArrayList<String>();
            while ((l = in.readLine()) != null) {
                array.add(l);
            }
            
            array.sort(new Comparador());
            for (String s : array) {
                out.println(s);
            }

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
