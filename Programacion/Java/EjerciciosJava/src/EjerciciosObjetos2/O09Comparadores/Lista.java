package EjerciciosObjetos2.O09Comparadores;

import java.util.ArrayList;
import java.util.Scanner;

public class Lista {
    
    private ArrayList<Contacto> listado;
    private Scanner teclado;

//-------------minimos----------------
    public Lista(ArrayList<Contacto> listado,Scanner teclado) {
        this.listado = listado;
        this.teclado = teclado;
    }
    public ArrayList<Contacto> getListado() {
        return listado;}
    public void setListado(ArrayList<Contacto> listado) {
        this.listado = listado;}
    @Override
    public String toString() {
        imprimir();
        return "";
    }

//-------------CASE 4---------
    public void imprimir(){
        for(Contacto c : listado){
            System.out.println(c);
        }
    }
    //------------helpers---------
    private int nextNum(){
        int numero;
        numero=Integer.parseInt(teclado.nextLine());
        return numero;
    }
    private char nextChar(){
        char caracter;
        caracter=teclado.nextLine().charAt(0);
        return caracter;
    }
    private boolean nextBool(){
        char opcion=nextChar();
        if (opcion=='s'||opcion=='S') {
            return true;
        }
        return false;
    }
    //-----------debug--------------
    public void debugAddCP(String correo, int telefono, String nombre, String apellido){
        listado.add(new ContactoPersona(correo, telefono, nombre, apellido));
    }
    public void debugAddCE(String correo, int telefono, String sector, int postal){
        listado.add(new ContactoEmpresa(correo, telefono, sector, postal));
    }
}
