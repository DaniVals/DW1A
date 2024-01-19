package EjerciciosObjetos.O25ListaContactos;

import java.util.ArrayList;

public class Contador {
    
    private String nombre;
    private int cantidad;

    public Contador(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public static int existe(ArrayList<Contador> lista,String buscado){
        
        for(int i=0;i<lista.size();i++){
            if (lista.get(i).getNombre().compareTo(buscado)==0) {
                return i;
            }
        }
        return -1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "  Sector:" + nombre + " numero:" + cantidad;
    }

    
}
