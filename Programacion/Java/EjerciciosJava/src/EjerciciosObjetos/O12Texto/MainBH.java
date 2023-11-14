package EjerciciosObjetos.O12Texto;

import java.util.Scanner;

public class MainBH {
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);

        BinarioHexadecimal textoTeclado;

        textoTeclado=new BinarioHexadecimal(teclado.nextLine());
        System.out.println(textoTeclado.binarioAhexadecimal());
        
        teclado.close();
    }
}
