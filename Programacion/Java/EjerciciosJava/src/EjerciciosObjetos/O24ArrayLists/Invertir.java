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
        nombres.add(1,"juana");
        
        System.out.println(nombres);
        invertirString(nombres);
        System.out.println(nombres);
        invertirString2(nombres);
        System.out.println(nombres);
        
    }

    public static void invertirString(ArrayList<String> lista){

        ArrayList<String> assist = new ArrayList<String>(lista);
        for(int j=0,i=lista.size()-1;i>=0;i--,j++){
            lista.set(j,assist.get(i));
        }
    }
    public static void invertirString2(ArrayList<String> lista){
        for(int i=lista.size()-1;i>=0;i--){
            lista.add(lista.get(i));
        }
        for(int i=lista.size()/2-1;i>=0;i--){
            lista.remove(i);
        }
    }

}
