package EjerciciosObjetos.O12Texto;

import java.util.Scanner;

public class CodificadoCesar {
        public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);

        String textoTeclado, textoResultado="";
        int charAssist=0;
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
        textoTeclado=teclado.nextLine();
        
        for (int i=0; i<textoTeclado.length();i++){
            charAssist=(textoTeclado.charAt(i)+numeroTeclado%26);
            System.out.println(textoTeclado.charAt(i)+1);
            if (charAssist>122) { //122='z'
                charAssist-=26;
            }
            if (textoTeclado.charAt(i)<97&&charAssist>90) { //90='Z'
                charAssist-=26;
            }
            textoResultado+=(char) charAssist;
        }
        System.out.println(textoResultado);
        
        teclado.close();
    }
}
