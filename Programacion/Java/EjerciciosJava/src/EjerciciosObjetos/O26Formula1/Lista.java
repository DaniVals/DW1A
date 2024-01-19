package EjerciciosObjetos.O26Formula1;

import java.util.ArrayList;
import java.util.Scanner;

public class Lista {
    
    private ArrayList<Piloto> listado;
    private Scanner teclado;

    //-------------minimos----------------
    public Lista(ArrayList<Piloto> listado,Scanner teclado) {
        this.listado = listado;
        this.teclado = teclado;
    }
    public ArrayList<Piloto> getListado() {
        return listado;}
    public void setListado(ArrayList<Piloto> listado) {
        this.listado = listado;}
    @Override
    public String toString() {
        imprimir(0);
        return "";
    }

    //------------CASE 1--------------
    public void pedirPiloto(){
        //crear datos
        int licencia;
        String nombre, apellido, nacionalidad;

        //pedir y verificar datos
        System.out.println("Licencia del piloto:");
        licencia=nextNum();
        while (licenciaRepetida(licencia)) {
            System.out.println("Licencia repetida, proporcione otra:");
            licencia=nextNum();
        }
        System.out.println("Nombre del piloto:");
        nombre=teclado.nextLine();
        System.out.println("Apellidos del piloto:");
        apellido=teclado.nextLine();
        System.out.println("Nacionalidad del piloto:");
        nacionalidad=teclado.nextLine();
        
        //añadir piloto
        System.out.println("Añadiendo piloto en la posicion "+listado.size());
        listado.add(new Piloto(licencia, nombre, apellido, nacionalidad, new ArrayList<Integer>()));
    }
    //-------------CASE 3---------
    public void addCarrera(){
        //crear datos
        int puntos, indexPiloto;

        //pedir y verificar datos
        indexPiloto=nextPiloto();
        
        //añadir piloto
        System.out.println("Añadiendo piloto en la posicion "+listado.size());
    }
    //-------------CASE 4---------
    public void imprimir(int minimo){
        for(Piloto p : listado){
            if (p.mediaPuntos()<=0) {
                System.out.println(p);
            }
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
    private int nextPiloto(){
        int index;
        System.out.println("Index del piloto:");
        index=nextNum();
        while (0<index&&index<listado.size()) {
            System.out.println("Index no valido, proporcione otro:");
            index=nextNum();
        }
        return index;
    }
    private boolean licenciaRepetida(int comprobado){
        for(int i=0;i<listado.size();i++){
            if (listado.get(i).getLicencia()==comprobado) {
                return true;
            }
        }
        return false;
    }
    //-----------debug--------------
    public void debugAddPiloto(int licencia, String nombre, String apellido, String nacionalidad){
        listado.add(new Piloto(licencia, nombre, apellido, nacionalidad, new ArrayList<Integer>()));
    }
}
