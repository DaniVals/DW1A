package src.F01Contar;

import java.io.FileInputStream;
import java.io.IOException;

public class Buscador {

    public static int ContarAll(char caracter, FileInputStream in) {
        int cont=1;
        try {


            int c;
            while ((c = in.read()) != -1) {
                if ((char)c == caracter) {
                    cont++;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }

    public static String ContarLinea(char caracter, FileInputStream in) {
        String devolver="";
        int cont=0;
        try {

            int c;
            while ((c = in.read()) != -1) {
                if ((char)c == caracter) {
                    cont++;
                }
                if (c == 13) {
                    devolver+=cont+", ";
                    cont=0;
                }
            }
            devolver+=cont;


        } catch (IOException e) {
            e.printStackTrace();
        }
        return devolver;
    }

    public static int ContarLineas(FileInputStream in) {
        int cont=1;
        try {

            int c;
            while ((c = in.read()) != -1) {
                if (c == 13) {
                    cont++;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return cont;
    }
}