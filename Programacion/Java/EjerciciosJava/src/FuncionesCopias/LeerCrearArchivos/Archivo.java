package FuncionesCopias.LeerCrearArchivos;

import java.io.*;
import java.util.Scanner;

public class Archivo {
    private String directorioCarpeta;
    private String nombreArchivo;
    private File archivo;
    private String texto;
    
    public Archivo(String directorioCarpeta, String nombreArchivo) {
        this.directorioCarpeta = directorioCarpeta;
        this.nombreArchivo = nombreArchivo;
        this.archivo = new File(directorioCarpeta+nombreArchivo);
        this.texto = this.leerArchivo();
    }
    @Override
    public String toString() {
        return this.leerArchivo();
    }
    public String leerArchivo(){
        try{
            String archivoBuilder="";
            Scanner lectorArchivo = new Scanner(this.archivo);

            //añadir la primera
            archivoBuilder=lectorArchivo.nextLine();
            while (lectorArchivo.hasNextLine()) { //añadir todas las lineas
                archivoBuilder=archivoBuilder+"\n"+lectorArchivo.nextLine();
            }
            lectorArchivo.close();
            return archivoBuilder.toString();
        } catch (FileNotFoundException error) {
            System.out.println("Error (por pollo)1:");
            error.printStackTrace();
            return "error";
        }
    }
    public void añadirLinea(String nuevo){
        try{
            FileWriter escritor = new FileWriter(this.archivo);
            for(int i=0; i<(this.texto+nuevo).length();i++){ //empieza en 1 porque si no añade un intro
                escritor.write((this.texto+nuevo).charAt(i));
            }
            escritor.close();
        } catch (IOException error) {
            System.out.println("Error (por pollo)4:");
            error.printStackTrace();
        }
    }
    public void remplazar(int jugador, String dato, String nuevo){
        String textoAssist="", textoDatos="";
        int contador=0, diferencia=0;

        //separar los datos del jugador para compararlos mas adelante sin interferencias
        for(int i=this.texto.indexOf(jugador+"{")+(jugador+"{").length()+1; i!=0;i++){
            if (this.texto.charAt(i)!='}') {
                textoDatos+=this.texto.charAt(i);
            }else{
                break;
            }
        }

        //calcular diferencia
        diferencia=buscar(jugador, dato).length()-nuevo.length();

        //sumar todo hasta los datos del jugador
        for(int i=0;
        i<=this.texto.indexOf(",\n"+jugador+"{")+(jugador+", {").length()
        +textoDatos.indexOf(dato+":")+(dato+":").length()
        ;i++){
            contador++;
            textoAssist+=this.texto.charAt(i);
        }    

        //sumar lo que falta en caso de que el numero introducido sea mayor o igual
        if (diferencia>=0) {
            textoAssist+=nuevo;
            contador+=nuevo.length();
            for(int i=contador+diferencia;i<this.texto.length();i++){
                textoAssist+=this.texto.charAt(i);
            }
        }else{
            //sumar espacios en caso de que sea menor
            textoAssist+=nuevo;
            contador+=nuevo.length()+diferencia;
            for(int i=contador;i<this.texto.length();i++){
                textoAssist+=this.texto.charAt(i);
            }
        }

        //sustituir el txt
        try{
            FileWriter escritor = new FileWriter(this.archivo);
            for(int i=0; i<textoAssist.length();i++){ //empieza en 1 porque si no añade un intro
                escritor.write(textoAssist.charAt(i));
            }
            escritor.close();
        } catch (IOException error) {
            System.out.println("Error (por pollo)5:");
            error.printStackTrace();
        }
    }
    public String buscar(int jugador, String dato){
        String textoDevolver="",textoDatos="";

        for(int i=this.texto.indexOf(",\n"+jugador+"{")+(jugador+", {").length()+1; i!=0;i++){
            if (this.texto.charAt(i)!='}') {
                textoDatos+=this.texto.charAt(i);
            }else{
                break;
            }
        }        
        for(int i=textoDatos.indexOf(dato+":")+(dato+":").length(); i!=0;i++){
            if (textoDatos.charAt(i)!='\n') {
                textoDevolver+=textoDatos.charAt(i);
            }else{
                break;
            }
        }

        return textoDevolver;
    }
    public void añadirJugador(){

    }


}
