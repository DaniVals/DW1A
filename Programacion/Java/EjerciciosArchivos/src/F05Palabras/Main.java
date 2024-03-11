package src.F05Palabras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
Crear un fichero de texto que guarde una palabra en cada línea. Mostrar por pantalla 
la  palabra  con  más  caracteres  (en  caso  de  empate  se  puede  mostrar  la  que  el  alumno 
desee). También crear un fichero con las palabras que son palíndromos (una por línea). 
*/
public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new FileReader("Programacion/Java/EjerciciosArchivos/src/F05Palabras/palabras.txt"));
            out = new PrintWriter(new FileWriter("Programacion/Java/EjerciciosArchivos/src/F05Palabras/palindromos.txt"));
            
            String l, larga = "";
            while ((l = in.readLine()) != null) {
                if (larga.length() < l.length()) {
                    larga = l;
                }
                if (esPalindromo(l)) {
                    out.println(l);
                }
            }

            System.out.println("larga: "+larga);

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
    public static boolean esPalindromo(String s){
        
        String textoAsist="";

        for (int i=s.length()-1; i>=0;i--){
            textoAsist+=s.charAt(i);
        }
        
        if (s.compareTo(textoAsist)==0) {
            return true;
        }
        return false;
    }
}
