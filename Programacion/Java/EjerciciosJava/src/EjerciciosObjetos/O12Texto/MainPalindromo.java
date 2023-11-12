package EjerciciosObjetos.O12Texto;

import java.util.Scanner;

public class MainPalindromo {
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);

        Palindromo textoTeclado;

        textoTeclado=new Palindromo(teclado.nextLine());
        System.out.println(textoTeclado.esPalindromo());
        
        teclado.close();
    }
}
