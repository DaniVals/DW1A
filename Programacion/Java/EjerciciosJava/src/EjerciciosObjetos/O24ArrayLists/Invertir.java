package EjerciciosObjetos.O24ArrayLists;

import java.util.ArrayList;

public class Invertir {
    public static void main(String[] args){
        //crear array
        ArrayList<String> nombres = new ArrayList<String>();
        
        nombres.add("Ana");
        nombres.add("Luisa");
        nombres.add("Felipe");
        nombres.add("Maria");
        
        System.out.println(nombres);
        invertirString(nombres);
        System.out.println(nombres);
        
    }

    //cambiarlo para no usar una lista auxiliar 
    //(añadirlo duplicado y borrar la mitad guardando el size en un int)
    public static void invertirString(ArrayList<String> lista){

        ArrayList<String> assist = new ArrayList<String>(lista);
        for(int j=0,i=lista.size()-1;i>=0;i--,j++){
            lista.set(j,assist.get(i));
        }
    }
}
