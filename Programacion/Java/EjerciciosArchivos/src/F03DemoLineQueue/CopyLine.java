package src.F03DemoLineQueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class CopyLine {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new FileReader("Programacion/Java/EjerciciosArchivos/src/F03DemoLineQueue/input.txt"));
            out = new PrintWriter(new FileWriter("Programacion/Java/EjerciciosArchivos/src/F03DemoLineQueue/output.txt"));

            String l;
            Queue<String> cola = new LinkedList<String>();

            while ((l = in.readLine()) != null) {
                cola.add(l);
            }

            cola = new PriorityQueue<>(cola);

            while (cola.peek() != null) {
                out.println(cola.poll());   
            }
            System.out.println(cola.peek());

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
