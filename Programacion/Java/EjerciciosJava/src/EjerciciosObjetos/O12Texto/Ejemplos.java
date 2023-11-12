package EjerciciosObjetos.O12Texto;

import java.util.Scanner;

public class Ejemplos {
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);

        String textoTeclado, textoAsist;
        int contador=0;
        char c1=' ', c2=' '; 

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
            c1=textoTeclado.charAt(i);
            c2=textoTeclado.charAt(textoTeclado.length()-1); 
            if (c1==c2) {
                contador++;
            }
        }System.out.println(contador); contador=0;
        for (int i=0; i<textoTeclado.length();i++){//El número de ocurrencias en la cadena del primer carácter
            c1=textoTeclado.charAt(i);
            c2=textoTeclado.charAt(0);
            if (c1==c2) {
                contador++;
            }
        }System.out.println(contador);

        textoAsist="***"+textoTeclado+"***"; //La cadena con tres asteriscos por delante y por detrás
        System.out.println(textoAsist);

        
        textoAsist=""; //La cadena invertida
        for (int i=textoTeclado.length()-1; i>-1;i--){
            textoAsist+=textoTeclado.charAt(i);
           
        }
        System.out.println(textoAsist);

        System.out.println(Integer.parseInt(textoTeclado)); //si la cadena SOLO son digitos, lo guardo como int
        
        teclado.close();
    }
}