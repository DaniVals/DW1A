package Ej1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {

    public static final String DIR_ARCHIVO_PAISES = "Programacion/Java/ExTerceraEv/src/paises.txt";
    public static final String DIR_ARCHIVO_PAISES_CON_FORMATO = "Programacion/Java/ExTerceraEv/src/Ej1/paisesConFormato.txt";
    public static final String DIR_ARCHIVO_PAISES_BINARIO = "Programacion/Java/ExTerceraEv/src/Ej1/paisesConLosRequisitos.bin";

    public static void main(String[] args) {
        
        try {

            // apartado a
            Pais.comprimirLineasDeUnArchivoEnOtro(DIR_ARCHIVO_PAISES, DIR_ARCHIVO_PAISES_CON_FORMATO);
            
            try {
                // apartado b
                ArrayList<Pais> paisesValidos = Pais.crearArrayListDePaisesValidosDesdeArchivoDeLineasCompimidas(DIR_ARCHIVO_PAISES_CON_FORMATO);
                
                // mostrarlos por pantalla
                // for (Pais pais : paisesValidos) {
                //     System.out.println(pais);
                // }
                    
                try {
                    // apartado c
                    Pais.crearArchivoBinarioConNombreYPoblacionDesdeArrayList(paisesValidos,DIR_ARCHIVO_PAISES_BINARIO);
                    
                } catch (Exception e) {
                    System.out.println("No se pudo realizar el apartado c");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println("No se pudo realizar el apartado b");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("No se pudo realizar el apartado a");
            e.printStackTrace();
        }
    }
}
