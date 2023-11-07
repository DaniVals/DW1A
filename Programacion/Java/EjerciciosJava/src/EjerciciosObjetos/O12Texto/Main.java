package EjerciciosObjetos.O12Texto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);

        String textoTeclado, textoAsist;
        int contador=0;

        textoTeclado=teclado.nextLine();

        System.out.println(textoTeclado.toUpperCase());//La cadena de caracteres en mayúsculas
        System.out.println(textoTeclado.toLowerCase());//La cadena de caracteres en minúsculas
        
        if (textoTeclado.length()>=2) {
            //Los dos primeros caracteres de la cadena(solo en caso de que la longitud de esta sea de dos o más caracteres)
            textoAsist=textoTeclado.substring(0, 2);
            System.out.println(textoAsist);
            //Los dos últimos caracteres de la cadena (solo en caso de que la longitud de esta sea de dos o más caracteres)
            textoAsist=textoTeclado.substring(textoTeclado.length()-2, textoTeclado.length());
            System.out.println(textoAsist);
        }else{
            System.out.println("no hay suficiente longitud");
        }
        for (int i=0; i<textoTeclado.length();i++){//El número de ocurrencias en la cadena del último carácter
            if (textoTeclado.substring(i, i+1)==textoTeclado.substring(textoTeclado.length()-1, textoTeclado.length())) {
                contador++;
            }
            System.out.println("-");
            System.out.println(textoTeclado.substring(i, i+1));
            System.out.println(textoTeclado.substring(textoTeclado.length()-1, textoTeclado.length()));
        }
        System.out.println(contador);
        System.out.println(textoTeclado);//La cadena con todas las ocurrencias del primer carácter en mayúsculas
        System.out.println(textoTeclado);//La cadena con tres asteriscos por delante y por detrás
        System.out.println(textoTeclado);//La cadena invertida
        
/*
 * si la cadena SOLO son digitos, lo guardo como int
 */


        teclado.close();
    }
}