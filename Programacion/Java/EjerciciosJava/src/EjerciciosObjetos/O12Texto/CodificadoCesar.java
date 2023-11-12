package EjerciciosObjetos.O12Texto;

import java.util.Scanner;

public class CodificadoCesar {
        public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);

        String textoTeclado, textoResultado="";
        char charAssist=' ';
        int numeroTeclado=0;

        /*  esto da error
        System.out.println("Numbero:");
        numeroTeclado=teclado.nextInt();
        System.out.println("Texto:");
        textoTeclado=teclado.nextLine();
        */

        System.out.println("Numero:");
        numeroTeclado=Integer.parseInt(teclado.nextLine());
        System.out.println("Texto:");
        textoTeclado=teclado.nextLine().toLowerCase();
        
        for (int i=0; i<textoTeclado.length();i++){
            charAssist=(char) (textoTeclado.charAt(i)+numeroTeclado%26);
            if (charAssist>122) {
                charAssist-=26;
            }
            textoResultado+=charAssist;
        }
        System.out.println(textoResultado);
        
        teclado.close();
    }
}
