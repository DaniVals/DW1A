package src.F00DemoByte;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
    
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i=0;i<SIZE;i++) {
            list.add (i);
        }
    }

    public void writeList() {
    // The FileWriter constructor throws IOException.
        PrintWriter out = null;
        try {
            out = new PrintWriter (new FileWriter ("OutFile.txt"));
            System.out.println ("Fichero creado");

            for (int i = 0; i < SIZE; i++) {
                // The get(int) method throws IndexOutOfBoundsException, which must be caught.
                out.println ("Value at: " + i + " = " + list.get(i));
            }
        }
        catch (IOException e) {

            System.err.println ("Error al crear el txt");
            e.printStackTrace();
        }
        finally {

            if (out!=null) {
                out.close();
            }
        }
    }
}