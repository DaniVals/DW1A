package EjerciciosObjetos2.O09Comparadores;

import java.util.ArrayList;
import java.util.Collections;
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
    public Scanner getTeclado() {
        return teclado;}
    @Override
    public String toString() {
        imprimir();
        return "";
    } 
//-------------CASE 1---------
    public void imprimir(){
        for(Contacto c : listado){
            System.out.println(c);
        }
    }
//-------------CASE 3---------
    public void ordenarTel(){
        System.out.println("ordenando...");
        Collections.sort(listado, new ComparadorTel());
        System.out.println("ordenado correctamente");
    }
//-------------CASE 4---------
public void ordenarAlfa(){
    System.out.println("ordenando...");
    Collections.sort(listado, new ComparadorTel());
    System.out.println("ordenado correctamente");
}
//-----------debug--------------
    public void debugAddCP(String correo, int telefono, String nombre, String apellido){
        listado.add(new ContactoPersona(correo, telefono, nombre, apellido));
    }
    public void debugAddCE(String correo, int telefono, String sector, int postal){
        listado.add(new ContactoEmpresa(correo, telefono, sector, postal));
    }
}
