package FuncionesCopias.LeerCrearArchivos;

import java.io.*;
import java.util.Scanner;

public class Archivo {
    private String directorioCarpeta;
    private String nombreArchivo;
    
    public Archivo(String directorioCarpeta, String nombreArchivo) {
        this.directorioCarpeta = directorioCarpeta;
        this.nombreArchivo = nombreArchivo;
    }
    public String leerArchivo(){
        try{
            String archivoBuilder="";
            File file1 = new File(directorioCarpeta+nombreArchivo);
            Scanner lectorArchivo = new Scanner(file1);
            
            while (lectorArchivo.hasNextLine()) {
                archivoBuilder=archivoBuilder+lectorArchivo.nextLine()+"\n";
            }
            
            lectorArchivo.close();
            return archivoBuilder.toString();
        } catch (FileNotFoundException error) {
            System.out.println("Error (por pollo)::");
            error.printStackTrace();
            return "error";
        }

    }
    public void remplazarArchivo(){

    }
}
