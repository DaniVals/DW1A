package EjerciciosObjetos.O24ArrayLists;

import java.util.ArrayList;

public class Ejemplo {
    public static void main(String[] args){
        ArrayList<String> nombres = new ArrayList();
        nombres.add("Ana");
        nombres.add("Luisa");
        nombres.add("Felipe");
        System.out.println(nombres); // [Ana, Luisa, Felipe]
        nombres.add(1, "Pablo");
        System.out.println(nombres); // [Ana, Pablo, Luisa, Felipe]                                                       
        nombres.remove(0);
        System.out.println(nombres); // [Pablo, Luisa, Felipe]
        nombres.set(0,"Alfonso");
        System.out.println(nombres); // [Alfonso, Luisa, Felipe]                                                          
        String s = nombres.get(1);
        String ultimo = nombres.get(nombres.size() - 1);
        System.out.println(s + " " + ultimo);  // Luisa Felipe
    }
}
