package EjerciciosObjetos.O24ArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class SumaMedia {
    public static void main(String[] args){

        //crear variables
        Scanner teclado = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<Integer>();

        //leer teclado
        int numTecaldo=1;
        while (numTecaldo!=0) {
            numTecaldo=teclado.nextInt();
            numeros.add(numTecaldo);
        }
        numeros.remove(numeros.size()-1);

        //procesar lista
        if (numeros.size()<=0) {
            System.out.println("no hay valores");
        }else{

            int suma=0;
            for(int i=0;i<numeros.size();i++){
                suma+=numeros.get(i);
            }
            System.out.println("Los numeros "+numeros);
            System.out.println("Suman "+suma);
            System.out.println("Median "+((double)suma/numeros.size()));
        }
        teclado.close();
    }
}
