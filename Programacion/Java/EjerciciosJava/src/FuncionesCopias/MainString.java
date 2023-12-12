package FuncionesCopias;

import java.util.Scanner;

public class MainString {
    public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);

        int[] a={6,5,3,4,2};
        int[] b;
        b=Arrays.ordenarArrayInt(a);

        System.out.println("sin ordenar");
        Arrays.mostrarArrayString(a);
        System.out.println("ordenado");
        Arrays.mostrarArrayString(b);

        teclado.close();
    }
}
