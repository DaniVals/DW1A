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
        return this.texto;
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
    public void reescribir(String nuevo){
        try{
            FileWriter escritor = new FileWriter(this.archivo);
            for(int i=0; i<(nuevo).length();i++){ //empieza en 1 porque si no añade un intro
                escritor.write((nuevo).charAt(i));
            }
            escritor.close();
        } catch (IOException error) {
            System.out.println("Error (por pollo)4:");
            error.printStackTrace();
        }
        //actualizar la variable texto
        this.texto = this.leerArchivo();
    }
    public void formatear(){
        String[] arrayDatos=new String[3]; //meter aqui todas las opciones con su valor default
        String stringDatos="";

        arrayDatos[0]="numJugadores=0";
        arrayDatos[1]="dificultad=0";
        arrayDatos[2]="arco=0";

        //pasarlo a un string
        for(String i: arrayDatos){
            stringDatos+=i+",\n";
        }
        reescribir(stringDatos);
    }
    
    public void remplazar(int jugador, String dato, String nuevo){
        String textoAssist="", textoDatos="";
        int contador=0, diferencia=0;
        //comprobar que el dato existe
        if (this.buscar(jugador, dato)!="NULL") {
            
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
    
            this.reescribir(textoAssist);
        }
    }
    public String buscar(int jugador, String dato){
        String textoDevolver="",textoDatos="";

        //comprovar que el jugador existe
        if (this.texto.indexOf(",\n"+jugador+"{")<=0) {
            return "NULL";
        }
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
        //en caso de que detecte de mas, añadira parte del nombre, el : y el dato
        //por lo que si el texto tiene un ':' es que no existe ese dato
        if (textoDevolver.indexOf(':')>=0) {
            return "NULL";
        }
        return textoDevolver;
    }
    
    public int detectarNumeroJugadores(){
        String textoDatos="";
        for(int i=this.texto.indexOf("numJugadores=")+("numJugadores=").length(); i!=0;i++){
            if (this.texto.charAt(i)!=',') {
                textoDatos+=this.texto.charAt(i);
            }else{
                break;
            }
        }
        return Integer.parseInt(textoDatos);
    }
    public void añadirJugador(){

    }


}
