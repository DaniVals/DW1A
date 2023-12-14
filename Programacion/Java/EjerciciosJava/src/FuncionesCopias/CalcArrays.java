package FuncionesCopias;

import java.util.Arrays;

public class CalcArrays {
    //metodos de nacho xdd
    public static int[] ordenarArrayInt(int[] arrayPasado){
        int[] arrayOrdenar=arrayPasado;
        int[] arrayOrdenado=new int[arrayOrdenar.length];
        int mayor=arrayOrdenar[0];
        int menor=arrayOrdenar[0];
        int posMenor=0;

        //sacar el mayor y el menor
        for(int i : arrayOrdenar){
            if (mayor<i) {
                mayor=i;
            }
            if (i<menor) {
                menor=i;
            }
        }
        //por cada posicion del nuevo array
        for(int i=0; i<arrayOrdenar.length;i++){
            //buscar el menor del array introducido
            for(int j=0; j<arrayOrdenar.length;j++){
                //si el numero es menor al ultimo del array ordenado, guardar su posicion
                if (arrayOrdenar[j]<=menor) {
                    posMenor=j;
                }
            }
            //poner el menor numero en el array
            arrayOrdenado[i]=arrayOrdenar[posMenor];
            //establecer ese numero al mayor para que no se detecte de nuevo
            arrayOrdenar[posMenor]=mayor;
            //cambiar el menor para el siguiente bucle
            menor=mayor;
            for(int k : arrayOrdenar){
                if (k<menor) {
                    menor=k;
                }
            }
        }
        return arrayOrdenado;
    }
    
    public static boolean buscarInt(int[] arrayPasado, int numBuscar){
        int i=(int)(arrayPasado.length/2+0.5); //TRUNCA hay que poner -1 al llamarlo
        int j=i; //valor de i anterior
        while (0<=i) {

            //comprobar si lo encuentra
            if (arrayPasado[i]==numBuscar) {
                return true;
            }
            
            j=i;
            //disminuir i
            if (numBuscar<arrayPasado[i]) {
                i=(int)(i/2);
            }
            //aumentar i
            if (arrayPasado[i]<numBuscar) {
                i=((int)i/2)+j;
            }
            //evitar que se pase de alto
            if (i>=arrayPasado.length) {
                i=arrayPasado.length-1;
            }
            //comprobar que no se queda estancado
            if (i==j) {
                return false;
            }
        }
        return false;
    }
    //metodos que si son utiles
    public static void printInt(int[] arrayAnalizar){
        for (int txt : arrayAnalizar) {
            System.out.println(txt);
        }
    }
}
