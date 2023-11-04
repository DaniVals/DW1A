package FuncionesCopias;

import java.util.Scanner;

public class ValidarPedirDatos {
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        

        int valorTeclado=0, valorMinimo=0,valorMaximo=0; //sustituir directamente;
        while (valorTeclado<=valorMinimo||valorTeclado>=valorMaximo) {
            System.out.println("Cuanto [sustituir]?");
            valorTeclado= teclado.nextInt();
        }

        teclado.close();
    }
}
