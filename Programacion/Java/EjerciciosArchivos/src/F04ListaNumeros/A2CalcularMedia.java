package src.F04ListaNumeros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
Realizar  otro  programa  que  leyendo  el  fichero  anterior  cree  un  nuevo  archivo  en  el 
que  se  almacenen  los  números  cuyo  valor  sea  mayor  que  la  media.  Además,  se  deberá 
mostrar por pantalla la suma total de los números y la media.
*/
public class A2CalcularMedia {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new FileReader("Programacion/Java/EjerciciosArchivos/src/F04ListaNumeros/notas.txt"));
            out = new PrintWriter(new FileWriter("Programacion/Java/EjerciciosArchivos/src/F04ListaNumeros/notas2.txt"));
            
            String l;
            int suma = 0,cont=0;
            while ((l = in.readLine()) != null) {
                suma += Integer.parseInt(l);
                cont++;
            }
            int media = (suma/cont), n;

            //reiniciar
            in.close();
            in = new BufferedReader(new FileReader("Programacion/Java/EjerciciosArchivos/src/F04ListaNumeros/notas.txt"));

            while ((l = in.readLine()) != null) {
                n=Integer.parseInt(l);
                if (media<n) {
                    out.write(n+"\n");
                }
            }
            System.out.println("suma:  "+suma);
            System.out.println("media: "+media);

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
